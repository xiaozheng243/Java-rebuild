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

### 添加熔断器监控

[原文](http://www.ityouknow.com/springcloud/2017/05/18/hystrix-dashboard-turbine.html)

## 远程配置Spring Cloud Config

分布式远程配置管理方案。

### 服务端

以`eureka-server`作为配置管理服务端。

#### 添加依赖

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

#### 添加注解

在主程序上添加注解`@EnableConfigServer`

#### 配置git信息

```YML
spring:
  cloud:
    config:
      server:
        git:
          uri: https://github.com/xiaozheng243/Java-rebuild/
          search-paths: practice/springboot/eureka-cluster/eureka-server/config-repo/
          username: xiaozheng243
          password: ******
          default-label: master
```



### client端

#### 添加依赖

```xml
<!--spring cloud config-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

#### 添加配置

client需要添加一个`bootstrap.yml`配置文件，当项目启动时会自动执行参数请求服务端的参数

```yaml
spring:
  cloud:
    config:
      name: application
      uri: http://localhost:7001
      label: master
      profile: dev
```

## 配置中心服务化与高可用

[原文](<http://www.ityouknow.com/springcloud/2017/05/25/springcloud-config-eureka.html>)

简单来说就是上文中将github远程配置放到单个eureka服务器中，这样服务端与客户端耦合性很高，所以就是重新注册一个服务单门获取远程配置，然后客户端直接调用即可。

## Spring cloud Zuul

*涉及模块：another-eureka-server、eureka-client、api-gateway*

[原文](http://www.ityouknow.com/springcloud/2017/06/01/gateway-service-zuul.html)

其原理是，向消费者所注册的服务中心注册一个zuul-gateway服务，然后提供动态路由，监控，弹性，安全等的边缘服务。外部服务调用时只需要走zuul就行了，而不需要走原生应用！

#### 添加依赖

首先，需要创建一个新的module用以开发zuul-gateway，其特殊依赖为

```xml
 <!--eureka-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
<!--zuul gateway-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zuul</artifactId>
</dependency>
```

**应当注意的一个细节为，此次的springboot版本号为*1.5.3.RELEASE*，这是因为，本次所用到的依赖spring-cloud-starter-zuul与1.5.19.RELEASE版本冲突**

#### 添加配置

```yaml
zuul:
  routes:
    eureka-client: # 被路由服务的application name
      path: /client-gateway/** # 路由后可通过此路径访问该服务
    yuluo-blog:
      path: /blog-gateway/**
```

#### 添加注解

给apiGatewayApplication添加`@EnableZuulProxy`来启动路由。

*到此完毕，我们发现，这个过程只添加了一个新的服务，并没有修改原有注册中心与注册服务。*

默认访问路径为<http://localhost:8001/user/getUserName>

现在可通过zuul访问：<http://localhost:8080/client-gateway/user/getUserName>

**如果没有指定服务地址的话，zuul会自动通过服务名称自动组装地址**，比如，当我尝试注释调某个服务的映射，zuul自动组装了地址：

```yaml
#    yuluo-blog: # 服务名
#      path: /blog-gateway/**
```

其组装地址为<http://localhost:8080/yuluo-blog/getRemoteUser/2>

http://[zuul_host]/[zuul_port]/[服务名]/正常地址

**记录一个问题**

当我访问原路径为<http://localhost:8001/user/getUserById/2>的方法时（此方法请求了数据库），路由必须访问<http://localhost:8080/client-gateway/user//getUserById/2>而非<http://localhost:8080/client-gateway/user/getUserById/2> 必须要多一个`/`。:cry:

## 分布式链路跟踪

[原文](<http://www.ityouknow.com/springcloud/2018/02/02/spring-cloud-sleuth-zipkin.html>)

简单来说就是使用zipkin实现每一次服务请求的完整调用信息，它会记录所有服务调用之间的耗时。

