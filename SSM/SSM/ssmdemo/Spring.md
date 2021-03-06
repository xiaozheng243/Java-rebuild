## Spring

[TOC]

-----------

### 优点

1. 轻量级、无侵入式
2. 控制反转(IOC)，降低耦合
3. 面向切面(AOP)，把业务逻辑与系统服务分开
4. 容器，管理应用对象的配置和生命周期，bean可配置且是单独实例
5. 框架集合，应用对象声明式组合，成为复杂的应用，集成了基础功能（事务管理、持久化框架集成。。。）

### 常用模块

1. 核心容器：BeanFactory是工厂模式的实现，利用的IOC将配置依赖与程序分离
2. 上下文：配置文件，提供上下文信息，包括企业服务，例如JNDI、EJB、电子邮件、国际化、校验和调度等。
3. AOP：可以将一些通用任务，如安全、事务、日志等管理，提高复用性和管理便携性
4. DAO：提供有意义的异常层次结构
5. ORM：提供了ORM的对象关系工具，包括JDI、Hibernate、iBatis SQL Map
6. WEB模块：简化了处理多部分请求及参数绑定对象的功能
7. MVC框架：全功能的web应用程序的MVC实现，包括了JSP、POI等技术。

## Spring IOC

`IOC`：Inversion of Control，控制反转，通过配置文件描述Bean与Bean之间的关系，利用反射实例化建立Bean之间的关系。常见的实现方式为依赖注入(DI)和依赖查找（Dependency Lookup）。

### IOC容器实现

BeanFactory是Spring的基础设施，但它主要面向Spring本身。ApplicationContext面向开发者，因此，几乎所有的场景都是用后者，而非底层的前者。

### xml方式

1. 将要使用的类在applicationContext.xml中注册为Bean以备使用

   ```xml
   <bean id="userService" class="online.yuluo.service.impl.UserService"/>
   ```

   id：Bean的唯一标识，也可使用name，不过name不是唯一标识

   class：Bean对象的全路径

   scope：Bean的作用范围

   1. singleton：单例（默认值），请求共用bean，线程不安全
   2. prototype：多例
   3. request：web项目中，每个http请求都会创建一个新的bean
   4. session：同一个http session共享一个bean
   5. globalsession：多服务器间的session

   init-method：初始化方法，可以配置目标类的初始化方法

   destroy-method：销毁方法，可以配置目标类的销毁方法

2. 通过工厂调用Bean

   ```java
   // 创建工厂
   ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
   // 获取Bean
   UserService us = (UserService) ac.getBean("userService");
   // 执行方法
   us.printHello();
   ```

#### 依赖注入DI

在配置xml的IOC控制反转时，可以通过为其设置参数来实现DI：

```xml
<bean id="userService1" class="online.yuluo.service.impl.UserService1"/>
<bean id="userService" class="online.yuluo.service.impl.UserService">
    <property name="userService1" ref="userService1"/>
</bean>
```

但是要确保userService调用userService1时给userService1创建了setter方法。

另一种方式就是通过构造器实现，即在xml中为bean配置`constructor-arg`属性，前提是UserService重载了构造方法！

#### 注解形式

[IOC](<https://github.com/xiaozheng243/Java-rebuild/tree/master/SSM/Spring/code/spring-annotation-ioc>)

## Spring AOP

面向切面编程，一种编程范式，通过模块化，隔离业务代码。

应用场景：

1. Authentication 权限
2. Caching 缓存
3. Context passing 内容传递
4. Error handling 错误处理
5. Lazy loading 懒加载
6. Debugging 调试
7. logging, tracing, profiling and monitoring 记录跟踪 优化 校准
8. Performance optimization 性能优化
9. Persistence 持久化
10. Resource pooling 资源池
11. Synchronization 同步
12. Transactions 事务

