package com.softnovo.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author cgm
 */
@Component
public class BussinessPerson implements Person, BeanNameAware, BeanFactoryAware, ApplicationContextAware,
        InitializingBean, DisposableBean, BeanPostProcessor, ApplicationListener<ContextRefreshedEvent>, Ordered {
    @Resource
    private List<Animal> animalList;

    public BussinessPerson() {
        System.out.println("构造器初始化完成");
    }

    @Override
    public void service() {
        if (!CollectionUtils.isEmpty(animalList)) {
            animalList.forEach(Animal::use);
        }
    }

    @Override
    //@Autowired
    public void setAnimal(@Qualifier("dog") Animal animal) {
        System.out.println("延迟依赖注入");
        //this.animal = animal;
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
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("-- ApplicationListener -- onApplicationEvent -- " + event);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-- 22222222BeanPostProcessor -- postProcessBeforeInitialization -- ");
        System.out.println("++ 22222222beanName -- " + beanName);
        System.out.println("++ 22222222Object -- " + bean.getClass().getName());
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
        System.out.println("-- 22222222BeanPostProcessor -- postProcessBeforeInitialization -- ");
        System.out.println("++ 22222222beanName -- " + beanName);
        System.out.println("++ 22222222Object -- " + bean.getClass().getName());
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

    @Override
    public int getOrder() {
        return 0;
    }
}
