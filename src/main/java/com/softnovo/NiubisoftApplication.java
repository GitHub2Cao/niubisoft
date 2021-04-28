package com.softnovo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
@MapperScan("com.softnovo.mapper")
public class NiubisoftApplication {

    public static void main(String[] args) {
        SpringApplication.run(NiubisoftApplication.class, args);
    }

}
