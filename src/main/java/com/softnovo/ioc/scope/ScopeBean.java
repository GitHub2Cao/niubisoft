package com.softnovo.ioc.scope;

import lombok.Data;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author cgm
 */
@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope("threadLocalScope")
@Data
public class ScopeBean {
    @Resource
    private BeanFactory applicationContext;
    @Resource
    private ApplicationContext beanFactory;
}
