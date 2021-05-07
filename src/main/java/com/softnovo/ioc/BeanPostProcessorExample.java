package com.softnovo.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author cgm
 */
@Component
public class BeanPostProcessorExample implements BeanPostProcessor, Ordered {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-- 11111111BeanPostProcessor -- postProcessBeforeInitialization -- ");
        System.out.println("++ 11111111beanName -- " + beanName);
        System.out.println("++ 11111111Object -- " + bean.getClass().getName());
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-- 11111111BeanPostProcessor -- postProcessBeforeInitialization -- ");
        System.out.println("++ 11111111beanName -- " + beanName);
        System.out.println("++ 11111111Object -- " + bean.getClass().getName());
        return bean;
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
