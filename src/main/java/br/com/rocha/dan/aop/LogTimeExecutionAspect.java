package br.com.rocha.dan.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
public class LogTimeExecutionAspect {


    @Around("@annotation(br.com.rocha.dan.annotation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        final StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        Object proceed = joinPoint.proceed();

        stopWatch.stop();
        System.out.println("\""+joinPoint.getSignature()+"\" executed in "+stopWatch.getTotalTimeMillis()+" ms");

        return proceed;
    }

}

