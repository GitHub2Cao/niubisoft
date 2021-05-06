package com.softnovo.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author cgm
 */
@Component
public class BeanPostProcessorExample implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-- BeanPostProcessor -- postProcessBeforeInitialization -- ");
        System.out.println("++ beanName -- " + beanName);
        System.out.println("++ Object -- " + bean.getClass().getName());
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-- BeanPostProcessor -- postProcessBeforeInitialization -- ");
        System.out.println("++ beanName -- " + beanName);
        System.out.println("++ Object -- " + bean.getClass().getName());
        return bean;
    }
}
