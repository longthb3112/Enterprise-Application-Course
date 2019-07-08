package edu.mum.cs544.bank;

import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Date;

@Aspect
@Component
public class LogAspect {
    @Autowired
    private ILogger logger;

    @Before("execution(* edu.mum.cs544.bank.dao.*.*(..))")
    public void logDAO(JoinPoint joinpoint) {
        logger.log(new Date() + " DAO method= " +  joinpoint.getSignature().getName());
    }
    @Around("target(edu.mum.cs544.bank.service.IAccountService)")
    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        // print the time to the console
        System.out.println("Time to execute save = "+ totaltime);
        return retVal;
    }
    @Before("target(edu.mum.cs544.bank.jms.IJMSSender)")
    public void logJMS(JoinPoint joinpoint) {
        logger.log(new Date() + " JSM method= " +  joinpoint.getSignature().getName());
    }
}
