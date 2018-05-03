package online.suiyu.annotationaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component(value = "myAspect")
@Aspect
public class MyAspect {
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
}
