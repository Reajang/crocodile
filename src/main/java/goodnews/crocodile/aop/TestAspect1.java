package goodnews.crocodile.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect1 {

    @Pointcut("execution(public * goodnews.crocodile.services.implementations.UserServiceTemplate.*(..))")
    public void one() {}

    @After("one()")
    public void two(){
        System.out.println("Метод после сохранения пользователя");
    }
}
