package com.softnovo.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BussinessPerson implements Person, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanPostProcessor {
    private Animal animal = null;

    public BussinessPerson() {
        System.out.println("构造器初始化完成");
    }

    @Override
    public void service() {
        animal.use();
    }

    @Override
    @Autowired
    public void setAnimal(@Qualifier("dog") Animal animal) {
        System.out.println("延迟依赖注入");
        this.animal = animal;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("-- BeanNameAware -- setBeanName -- " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("-- BeanFactoryAware -- setBeanFactory -- " + beanFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("-- ApplicationContextAware -- setApplicationContext -- " + applicationContext);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-- BeanPostProcessor -- postProcessBeforeInitialization -- ");
        System.out.println("++ beanName -- " + beanName);
        System.out.println("++ Object -- " + bean.getClass().getName());
        return bean;
    }

    @PostConstruct
    public static void init() {
        System.out.println("@PostConstruct -- init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("-- InitializingBean -- afterPropertiesSet");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-- BeanPostProcessor -- postProcessBeforeInitialization -- ");
        System.out.println("++ beanName -- " + beanName);
        System.out.println("++ Object -- " + bean.getClass().getName());
        return bean;
    }

    @PreDestroy
    public static void destroyl() {
        System.out.println("@PreDestroy -- destroyl");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("-- DisposableBean -- destroy");
    }
}
