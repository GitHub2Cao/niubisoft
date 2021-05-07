package com.softnovo.ioc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author cgm
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ServiceImpl {
    private final String serviceName;
    private final String otherStringParameter;

    @Autowired
    public ServiceImpl(String serviceName, String otherStringParameter) {
        this.serviceName = serviceName;
        this.otherStringParameter = otherStringParameter;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getOtherStringParameter() {
        return otherStringParameter;
    }
}
