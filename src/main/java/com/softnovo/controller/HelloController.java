package com.softnovo.controller;

import com.softnovo.config.MybatisConfig;
import com.softnovo.config.PropertySourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Value("${server.port}")
    private String port;
    //@Value("${timeout}")
    private Long timeout;
    @Value("${name}")
    private String name;

    @Value("${timeout}")
    public void setTimeout(Long timeout) {
        this.timeout = timeout;
        System.out.println("===== timeout " + timeout);
    }

    @Resource
    private MybatisConfig mybatisConfig;
    @Resource
    private PropertySourceConfig propertySourceConfig;

    @RequestMapping("/")

    public static String hello() {
        return "Hello World!";
    }

    @GetMapping("/hi")
    public String hi(String name1) {
        HelloController.logger.debug("debug log...");
        HelloController.logger.info("info log...");
        HelloController.logger.warn("warn log...");
        return "hi " + name1 + " ,i am from port:" + port + ", timeout = " + timeout + ", " + name;
    }

    @GetMapping("/config")
    public String config() {
        return mybatisConfig.getConfigLocation() + "+++++" + mybatisConfig.getMapperLocations() + "----"
                + propertySourceConfig.getA() + propertySourceConfig.getB() + propertySourceConfig.getC();
    }
}
