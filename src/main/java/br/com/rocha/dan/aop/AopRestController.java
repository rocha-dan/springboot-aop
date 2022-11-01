package br.com.rocha.dan.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopRestController {

    @Pointcut(value = "within(@org.springframework.web.bind.annotation.RestController *)")
    public void userPointCut(){

    }

    @Before(value = "userPointCut() ")
    public void beforeAdvice(JoinPoint point){
        String methodName = point.getSignature().getName();
        System.out.println("@Before Advice: method:" + methodName);
    }

    @After(value = "userPointCut()")
    public void afterAdvice(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("@After Advice: " + methodName);
    }

    @AfterReturning(value = "userPointCut() && args(groupId,..)", returning = "result")
    public void afterReturningAdvice(JoinPoint point, Object result, String groupId){
        String methodName = point.getSignature().getName();
        System.out.println("@AfterReturning Advice：methodName=" + methodName + " groupId="+groupId+ " result=" + result.toString());
    }

}