## Eureka集群

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

整合Mybatis查看[此处](https://juejin.im/post/5bc4833e6fb9a05cd7776db7)