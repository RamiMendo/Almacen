package com.ramitax.component;

import com.ramitax.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    private static final Logger log = LoggerFactory.getLogger(Aspect.class);

    @Pointcut("execution(* com.ramitax.service.*.save(*))")
    private void ejecutarSave(){}

    @Pointcut("execution(* com.ramitax.service.*.update(*))")
    private void ejecutarUpdate(){}

    @Around("execution(* com.ramitax.service.*.findById(*))")
    public Object findById(ProceedingJoinPoint joinPoint) throws Throwable {
        Object args = joinPoint.getArgs()[0];

        if(Objects.equals(args.toString(), "0"))
            throw new CustomException("ID MAL INGRESADO!\nDEBE SER MAYOR A CERO.", HttpStatus.BAD_REQUEST);

        Object response = joinPoint.proceed();
        if (response == null){
            throw new CustomException("NO EXISTE EN BASE DE DATOS!", HttpStatus.NOT_FOUND);
        }

        return response;
    }
}
