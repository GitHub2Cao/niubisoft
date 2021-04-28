package com.softnovo.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class OrderRawJdbcRepositoryTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        //System.out.println("========" + this.applicationContext.getBean(HelloController.class));
        //System.out.println("========" + this.applicationContext.getBean(HelloController.class).getClass().getCanonicalName());
        Assert.assertNotNull(this.applicationContext);
    }
}
