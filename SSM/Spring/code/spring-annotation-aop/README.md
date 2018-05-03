## 注解实现Spring中AOP

### 配置文件

```xml
<context:component-scan base-package="online.suiyu.annotationaop"/>
<aop:aspectj-autoproxy/>
```
第一行代码开启了IOC扫描
第二行代码开启了AOP自动代理

### 代理程序

```java
@Component(value = "myAspect")
@Aspect
public class MyAspect {
    @Before(value = "execution(public void online.suiyu.annotationaop.service.impl.UserServiceImpl.save())")
    public void log() {
        System.out.println("log增强！");
    }
}
```
`@Aspect`为增强程序所在类的注解
`@Before`为增强方法，其value值使用方式与XML方式相同

### 简化增强
如果想要对同一个方法实行多种增强，可以使用下面的方法：
```java
@Before(value = "execution(public void online.suiyu.annotationaop.service.impl.UserServiceImpl.save())")
public void log() {
    System.out.println("log前增强！");
}
@After(value = "execution(public void online.suiyu.annotationaop.service.impl.UserServiceImpl.save())")
public void log() {
    System.out.println("log后增强！");
}
```

但是，很显然，这种方法重复性工作太多，因此需要简化

```java
@Before(value = "MyAspect.myAspect()")
    public void log() {
        System.out.println("log增强！");
    }

    @Around(value = "MyAspect.myAspect()")
    public void aroundLog(ProceedingJoinPoint joinPoint) {
        System.out.println("开始处增强");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("结束处增强");
    }

    @Pointcut(value = "execution(public void online.suiyu.annotationaop.service.impl.UserServiceImpl.save())")
    public void myAspect() {
    }
```

1. 使用自定义的`@Pointcut`注解可以设置切入点，然后可以在其他注解上直接使用
2. `@Around`注解可以配合ProceedingJoinPoint来实现对save方法的环绕增强

