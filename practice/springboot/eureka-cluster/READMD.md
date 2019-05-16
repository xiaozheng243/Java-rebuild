## Eureka集群

*搭建微服务时，请注意SPringBoot与SpringCloud版本对应*

问题描述：

```XML
Error starting ApplicationContext. To display the auto-configuration report re-run your application with 'debug' enabled.
2019-05-15 16:18:41.429 ERROR 14692 --- [  restartedMain] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

Field userDao in online.yuluo.eurekaclient.online.yuluo.service.impl.UserService required a bean of type 'online.yuluo.eurekaclient.online.yuluo.dao.IUserDao' that could not be found.


Action:

Consider defining a bean of type 'online.yuluo.eurekaclient.online.yuluo.dao.IUserDao' in your configuration.

```

1. 确认数据库连接驱动与数据库版本号对应
2. 主方法上使用扫描`@MapperScan("online.yuluo.eurekaclient.online.yuluo.dao")`

错误：

```shell
java.sql.SQLNonTransientConnectionException: Public Key Retrieval is not allowed
```



整合Mybatis查看[此处](https://juejin.im/post/5bc4833e6fb9a05cd7776db7)



## 服务发现

本次使用注册服务yuluo-blog通过eureka server发现已经注册的Eureka client服务。

[原文](http://www.ityouknow.com/springcloud/2017/05/12/eureka-provider-constomer.html)

#### 写入依赖

本次服务发现使用的是Feign，因此，只需在服务调用方(消费者服务yuluo-blog)中的依赖中加入feign依赖即可。

```xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-feign</artifactId>
</dependency>
```

#### 配置注解

需要在生产者与消费者的主方法中都加入`@EnableDiscoveryClient`，以备服务发现。该注解存在于eureka依赖中的。

#### 远程调用

消费者需要创建一个FeignClient接口指向远程服务与接口才能真正调用远程生产者。

```java
@FeignClient(name = "eureka-client")
public interface HelloRemote {
    @RequestMapping(value = "/user/getUserById/{id}", method = RequestMethod.GET)
    UserInfoVO getUserById(@PathVariable("id") int id);
}
```

注意点：

1. 注解`@FeignClient`中的name属性必须是生产者的`spring.application.name`配置，这样才能在注册中心定位
2. `@RequestMapping`中的value值必须是生产者自身接口的地址（从类到方法的本地相对地址），且请求方式不能改变
3. 方法名与参数列表要与生产者一致。

## 熔断器

[原文](http://www.ityouknow.com/springcloud/2017/05/16/springcloud-hystrix.html)

简单来说，当一个服务存在异常，无法向外提供功能时，调用者仍然会不停的访问，这会浪费大量的资源与时间。因此，我们需要在生产者存在异常时，当消费者想要调用它时，会执行快速失败，直接返回错误。

### Hystrix

> 断路器很好理解, 当Hystrix Command请求后端服务失败数量超过一定比例(默认50%), 断路器会切换到开路状态(Open). 这时所有请求会直接失败而不会发送到后端服务. 断路器保持在开路状态一段时间后(默认5秒), 自动切换到半开路状态(HALF-OPEN). 这时会判断下一次请求的返回情况, 如果请求成功, 断路器切回闭路状态(CLOSED), 否则重新切换到开路状态(OPEN). Hystrix的断路器就像我们家庭电路中的保险丝, 一旦后端服务不可用, 断路器会直接切断请求链, 避免发送大量无效请求影响系统吞吐量, 并且断路器有自我检测并恢复的能力.

### Fallback

简单来说，fallback可以实现设置默认值或缓存的功能，当调用服务失败时返回默认信息。

### 资源隔离

对于调用的不同服务，Hystrix使用的是不同线程池，这样不会因bug而消耗所有线程，代价就是维护多个线程池。如果你对自己确保服务不会出现问题并且需要降低开销，可以使用信号模式。

| 模式   | 支持线程切换 | 支持异步 | 支持超时 | 支持熔断 | 开销大小 | 支持限流 |
| ------ | ------------ | -------- | -------- | -------- | -------- | -------- |
| 信号量 | ×            | ×        | ×        | √        | 小       | √        |
| 线程池 | √            | √        | √        | √        | 大       | √        |

信号模式默认并发量为10，排队上限为5.

### 开始

1. 在消费者的配置文件中启用Hystrix（因为Feign中已经存在hystrix了，所以无需额外依赖）

   ```YML
   feign:
   	hystrix
   		enabled: true
   ```

2. 指定fallback，需要指定当生产者出现问题时，熔断出发的方法，创建一个类实现HelloRemote。

   要保证实现的方法其方法名与参数列表一致，建议直接复制。为了该类被发现，可以使用注解`@Component`注册一个bean。

3. 其他不用修改，到此完成，可以测试，当生产者停止时，是否出发熔断器返回默认值。

如果调用接口时出现提示*无法注入，存在多个helloremote Bean*时，这并不会影响程序运行，可以尝试在接口上方加入注解`@primary`。

*@Primary*主要是当存在多个接口实现且他们都被注册为bean时，告诉ioc容器默认使用哪个bean。

