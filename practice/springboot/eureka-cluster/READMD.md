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

