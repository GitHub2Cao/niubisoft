package com.softnovo.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(lazyInit = true)
@Configuration
public class SpringConfig {
}
