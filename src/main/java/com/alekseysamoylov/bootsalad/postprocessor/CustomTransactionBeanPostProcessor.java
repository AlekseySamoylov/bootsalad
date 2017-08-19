package com.alekseysamoylov.bootsalad.postprocessor;

import com.alekseysamoylov.bootsalad.annotation.CustomTransactional;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;


public class CustomTransactionBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Class> beanNameClassMap = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        if (clazz.isAnnotationPresent(CustomTransactional.class)) {
            beanNameClassMap.put(beanName, clazz);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = beanNameClassMap.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(
                    beanClass.getClassLoader(),
                    beanClass.getInterfaces(),
                    (proxy, method, args) -> {
                        System.out.println("**** Custom transaction opened ****");

                        Object returnValue = method.invoke(bean, args);

                        System.out.println("**** Custom transaction closed ****");

                        return returnValue;
                    });
        }
        return bean;
    }
}
