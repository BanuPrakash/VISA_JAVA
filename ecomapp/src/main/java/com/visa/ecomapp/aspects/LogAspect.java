package com.visa.ecomapp.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    Logger logger = LoggerFactory.getLogger(LogAspect.class);
    //https://docs.spring.io/spring-framework/docs/2.0.8/reference/aop.html
    @Before("execution(* com.visa.ecomapp.service.OrderService.*(..))")
    public void logBefore(JoinPoint jp) { // gets a reference to the invoked method
        Object[] args = jp.getArgs();
        logger.info("Method "  + jp.getSignature().getName());
        logger.info("Arguments ");
        for(Object arg : args) {
            logger.info("Argument : " + arg);
        }
    }

    @After("execution(* com.visa.ecomapp.service.*.*(..))")
    public void logAfter() {
        logger.info("***************");
    }

    @AfterReturning( value = "execution(* com.visa.ecomapp.service.*.get*(..))", returning = "obj")
    public void logAfter(JoinPoint jp, Object obj) {
        logger.info(jp.getSignature().getName() + " returns " + obj);
    }

    @AfterThrowing(value = "execution(* com.visa.ecomapp.service.*.*(..))", throwing = "ex")
    public void logException(JoinPoint jp, Exception ex) {
        logger.info("Exception in " + jp.getSignature().getName() + " Exception : " + ex.getMessage());
    }
}
