## Spring中AOP的XML实现

AOP(面向切面编程)是一种编程范式。
使用Java代理
降低耦合性、模块化、提高效率

```xml
    <bean id="userService" class="online.suiyu.aopxml.service.impl.UserServiceImpl"/>
    <bean id="userDao" class="online.suiyu.aopxml.dao.impl.UserDaoImpl"/>
    <bean id="myAspect" class="online.suiyu.aopxml.MyAspect"/>

    <aop:config>
        <aop:pointcut id="userService"
                      expression="execution(public void online.suiyu.aopxml.service.impl.UserServiceImpl.save())"/>
        <aop:aspect ref="myAspect">
            <aop:before method="log"
                        pointcut-ref="userService"/>
        </aop:aspect>
    </aop:config>
```

userService的save方法是被增强方法。myAspect的log会在save执行前执行一次来增强save方法。
aop需要配置切入点，切入时机与切入的类和方法
切入时机分为：
1. before
2. after
3. around
4. after-returning
5. after-throwing

 **相关术语**
1. Joinpoint(连接点)	-- 所谓连接点是指那些被拦截到的点。在spring中,这些点指的是方法,因为spring只支持方法类型的连接点
2. Pointcut(切入点)		-- 所谓切入点是指我们要对哪些Joinpoint进行拦截的定义
3. Advice(通知/增强)	-- 所谓通知是指拦截到Joinpoint之后所要做的事情就是通知.通知分为前置通知,后置通知,异常通知,最终通知,环绕通知(切面要完成的功能)
4. Introduction(引介)	-- 引介是一种特殊的通知在不修改类代码的前提下, Introduction可以在运行期为类动态地添加一些方法或Field
5. Target(目标对象)		-- 代理的目标对象
6. Weaving(织入)		-- 是指把增强应用到目标对象来创建新的代理对象的过程
7. Proxy（代理）		-- 一个类被AOP织入增强后，就产生一个结果代理类
8. Aspect(切面)			-- 是切入点和通知的结合，以后咱们自己来编写和配置的


## 底层实现

1. Srping框架的AOP技术底层也是采用的代理技术，代理的方式提供了两种
	1. 基于JDK的动态代理
		* 必须是面向接口的，只有实现了具体接口的类才能生成代理对象
	
	2. 基于CGLIB动态代理
		* 对于没有实现了接口的类，也可以产生代理，产生这个类的子类的方式

2. Spring的传统AOP中根据类是否实现接口，来采用不同的代理方式
	1. 如果实现类接口，使用JDK动态代理完成AOP
	2. 如果没有实现接口，采用CGLIB动态代理完成AOP
	
## 依赖JAR包

* spring的传统AOP的开发的包
    * spring-aop-4.2.4.RELEASE.jar
    * com.springsource.org.aopalliance-1.0.0.jar

* aspectJ的开发包
    * com.springsource.org.aspectj.weaver-1.6.8.RELEASE.jar
    * spring-aspects-4.2.4.RELEASE.jar

所以，使用idea自动下载的spring，需要导入一个aspectjweaver的jar包才行

## 测试类

```java
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
    UserService userService = (UserService) applicationContext.getBean("userService");
    userService.save();
```

**注意：getBean在获取Bean时不可以使用接口实现的类，只能使用接口！**

