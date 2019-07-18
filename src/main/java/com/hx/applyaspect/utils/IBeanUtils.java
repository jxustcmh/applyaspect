package com.hx.applyaspect.utils;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * created by Allen.Huang on 2019/7/3
 */
public class IBeanUtils {
    private static final Map<Class<?>, Map<Class<?>, BeanCopier>> beanCopierMap = new HashMap<>();

    public static void copyProperties(Object source, Object target) {
        copyProperties(source, target, null);
    }

    public static void copyProperties(Object source, Object target, Converter converter) {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();
        getBeanCopier(sourceClass, targetClass, converter).copy(source, target, converter);
    }

    public static <T> T createBeanAndProperties(Object source, Class<T> targetClass) {
        try {
            return createBeanAndProperties(source, targetClass, null);
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public static <T> T createBeanAndProperties(Object source, Class<T> targetClass, Converter converter) throws IllegalAccessException, InstantiationException {
        Class<?> sourceClass = source.getClass();
        BeanCopier beanCopier = getBeanCopier(sourceClass, targetClass, converter);
        T object = targetClass.newInstance();
        beanCopier.copy(source, object, converter);
        return object;
    }

    public static BeanCopier getBeanCopier(Class<?> sourceClass, Class<?> targetClass, Converter converter) {
        Map<Class<?>, BeanCopier> copierMap = beanCopierMap
                .computeIfAbsent(sourceClass, k -> new HashMap<>());
        return copierMap.computeIfAbsent(targetClass,
                k -> BeanCopier.create(sourceClass, targetClass, !Objects.isNull(converter)));
    }

}
