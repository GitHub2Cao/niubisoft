package com.softnovo;

import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {" springcss.order.point = 11"})
public class EnvironmentTests {
    @Resource
    public Environment environment;
    @Resource
    private SpringApplication springApplication;

    @Test
    public void testEnvValue() {
        //SpringApplication springApplication = new SpringApplication();
        Map<String, Object> map = Maps.newHashMap();
        map.put("springcss.order.point", 13);
        springApplication.setDefaultProperties(map);
        System.out.println("=======" + Integer.parseInt(environment.getProperty("springcss.order.point")));
    }
}
