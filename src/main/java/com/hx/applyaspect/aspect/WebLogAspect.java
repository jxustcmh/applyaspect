package com.hx.applyaspect.aspect;

import com.hx.applyaspect.utils.IStrings;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author minghua.c
 * @date 2019-07-18 10:00
 */
@Slf4j
@Component
@Aspect
public class WebLogAspect {
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.hx.applyaspect.controller..*.*(..))")
    public void webLog() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        doBeforeSomething(joinPoint);
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        doAfterSomeThing();
    }

    private void doBeforeSomething(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            log.info(IStrings.splice("请求地址: ", request.getRequestURL().toString()));
            log.info(IStrings.splice("请求类型: ", request.getMethod()));
            log.info(IStrings.splice("IP: ", request.getRemoteAddr()));
            log.info(IStrings.splice("匹配方法: ", joinPoint.getSignature().getDeclaringTypeName(), ".", joinPoint.getSignature().getName()));
            log.info(IStrings.splice("方法参数: ", Arrays.toString(joinPoint.getArgs())));
        } else {
            log.warn("AOP失效，ServletRequestAttributes是空的.");
        }
    }

    private void doAfterSomeThing() {
        log.info(IStrings.splice("接口耗时: ", (System.currentTimeMillis() - startTime.get()), "ms."));
        startTime.remove();
    }
}

