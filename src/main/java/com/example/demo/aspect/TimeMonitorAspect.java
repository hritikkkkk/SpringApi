package com.example.demo.aspect;



import com.example.demo.Annotations.TimeMonitor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {

    @Around("@annotation(timeMonitor)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, TimeMonitor timeMonitor) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();  // Call the actual method

        long duration = System.currentTimeMillis() - start;

        System.out.println(joinPoint.getSignature() + " executed in " + duration + "ms");

        return result;
    }
}
