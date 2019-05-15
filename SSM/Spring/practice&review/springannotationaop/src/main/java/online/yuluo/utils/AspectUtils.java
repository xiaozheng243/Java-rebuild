package online.yuluo.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectUtils {

    @Before(value = "execution(public void online.yuluo.controller.UserController.getUser())")
    public void log() {
        System.out.println("log增强-before");
    }

    // 抛出异常
    @AfterThrowing
    public void exceptionLog() {

    }

    @AfterReturning
    public void retureLog() {

    }

    @Around(value = "AspectUtils.myAspect()")
    public void aroundLog(ProceedingJoinPoint joinPoint) {
        System.out.println("log增强-Around1");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("\"log增强-Around2");
    }

    @Pointcut(value = "execution(public void online.yuluo.controller.UserController.getUser())")
    public void myAspect() {

    }
}
