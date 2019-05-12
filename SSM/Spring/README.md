## 目录

1. spring-xml-ioc：Spring IOC的xml写法
2. spring-annotation-ioc：Spring IOC的注解写法
3. spring-xml-aop：Spring Aop的xml写法
4. spring-annotation-aop ：Spring Aop的注解写法
5. spring-jdbc：Spring的默认数据库连接池（DriverManageDataSource）写法

## Spring

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

## Spring之IOC

`IOC`：Inversion of Control，控制反转，通过配置文件描述Bean与Bean之间的关系，利用反射实例化建立Bean之间的关系。常见的实现方式为依赖注入(DI)和依赖查找（Dependency Lookup）。

### IOC容器实现

BeanFactory是Spring的基础设施，但它主要面向Spring本身。ApplicationContext面向开发者，因此，几乎所有的场景都是用后者，而非底层的前者。