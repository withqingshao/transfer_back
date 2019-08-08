package com.zsq.datatransfer.aop;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;

@Aspect
@Component
@Order(1)
@Slf4j
public class LogAop {

    private Gson gson=new Gson();


    @Pointcut("execution(public * com.zsq.datatransfer.controller.*.*(..))")
    private void controllerAspect(){}

    @Pointcut("execution(public * com.zsq.datatransfer.gloab.GlobalExceptionHandler.*(..))")
    private void exceptionAspect(){}
    //请求method前打印内容

    @Before(value = "controllerAspect()")

    public void methodBefore(JoinPoint joinPoint){

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = requestAttributes.getRequest();

        //打印请求内容

        log.info("===============请求内容===============");

        log.info("请求地址:"+request.getRequestURL().toString());

        log.info("请求方式:"+request.getMethod());

        log.info("请求类方法:"+joinPoint.getSignature());

        Signature signature = joinPoint.getSignature();
//        Class<?> aClass = joinPoint.getTarget().getClass();
//        System.out.println(aClass);
        //aClass.getDeclaredMethod()


        log.info("请求类方法参数:"+ Arrays.toString(joinPoint.getArgs()));

        log.info("===============请求内容===============");

    }


    //在方法执行完结后打印返回内容

    @AfterReturning(returning = "o",pointcut = "controllerAspect()")

    public void methodAfterReturing(Object o ){

        log.info("--------------正常执行返回内容----------------");

        log.info("Response内容:"+gson.toJson(o));

        log.info("--------------正常执行返回内容----------------");

    }

    //异常方法结果日志打印
    @AfterReturning(returning = "o",pointcut = "exceptionAspect()")
    public void methodExceptionReturing(Object o){
        log.info("--------------异常返回内容----------------");

        log.info("异常Response内容:"+gson.toJson(o));

        log.info("--------------异常返回内容----------------");
    }


}
