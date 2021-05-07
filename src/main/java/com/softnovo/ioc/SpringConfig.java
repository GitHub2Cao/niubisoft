package com.softnovo.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author cgm
 */
@ComponentScan(lazyInit = true)
@Configuration
public class SpringConfig {
    @Bean
    public static String serviceName() {
        return "cccccc";
    }

    @Bean
    public static String otherStringParameter() {
        return "otherStringParameter";
    }

}
