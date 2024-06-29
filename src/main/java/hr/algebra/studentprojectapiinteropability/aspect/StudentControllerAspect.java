package hr.algebra.studentprojectapiinteropability.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentControllerAspect {

    @Pointcut("execution(* hr.algebra.studentprojectapiinteropability.controller.*.*(..))")
    public void serviceMethods() {
    }

    // Aspect to measure execution time of methods
    @Around("serviceMethods()")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println(joinPoint.getSignature() + " executed in " + duration + "ms");

        return result;
    }

    @Before("serviceMethods()")
    public void logMethodEntry(JoinPoint joinPoint) {
        System.out.println("Entering " + joinPoint.getSignature().getName() + " method");
    }

}
