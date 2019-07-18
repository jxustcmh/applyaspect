package com.hx.applyaspect.aspect;

import com.hx.applyaspect.utils.IStrings;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author minghua.c
 * @date 2019-07-18 9:53
 */
@Slf4j
@Component
@Aspect
public class MapperLogAspect {
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     *  定义一个切点,后面应用
     */
    @Pointcut("execution(public * com.hx.applyaspect.mapper..*.*(..))")
    public void mapperLog() {

    }

    @Before("mapperLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        log.info(IStrings.splice("mapper方法: ", joinPoint.getSignature().getDeclaringTypeName(), ".", joinPoint.getSignature().getName()));
        log.info(IStrings.splice("mapper参数: ", Arrays.toString(joinPoint.getArgs())));
    }

    @AfterReturning(returning = "ret", pointcut = "mapperLog()")
    public void doAfter(Object ret) {
        log.info(IStrings.splice("mapper耗时: ", (System.currentTimeMillis() - startTime.get()), "ms"));
        startTime.remove();
    }


}
