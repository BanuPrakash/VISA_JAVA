package com.visa.ecomapp.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class TransactionalAspect {

    // ProceedingJoinPoint instead of JoinPoint for Around
    @Around("@annotation(Tx)")
    public Object doTransaction(ProceedingJoinPoint jp) throws Throwable{
        log.info("Transaction starts");
        try {
            // actual method
            Object ret = jp.proceed();
            log.info("Tx Commit!!!");
            return ret;
        } catch (Throwable throwable) {
            log.info("Transaction Rollback");
            throw  throwable;
        }
    }
}
