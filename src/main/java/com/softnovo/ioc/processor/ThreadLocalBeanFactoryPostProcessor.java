package com.softnovo.ioc.processor;

import com.softnovo.ioc.scope.ThreadLocalScope;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;


/**
 * @author cgm
 */
@Component
public class ThreadLocalBeanFactoryPostProcessor implements BeanFactoryPostProcessor, Ordered {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(" --------ThreadLocalBeanFactoryPostProcessor------- ");
        beanFactory.registerScope("threadLocalScope", new ThreadLocalScope());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
