package com.softnovo.config;

//@Component

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author cgm
 */
@Component
@PropertySource(value = {"classpath:abc.properties"}, ignoreResourceNotFound = true)
public class PropertySourceConfig {
    @Value("${cgm.a}")
    private String a;
    @Value("${cgm.b}")
    private String b;
    @Value("${cgm.c}")
    private String c;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
