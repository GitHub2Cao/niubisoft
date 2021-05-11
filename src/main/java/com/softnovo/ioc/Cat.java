package com.softnovo.ioc;

import org.springframework.stereotype.Component;

import javax.annotation.Priority;

/**
 * @author cgm
 */
@Component
@Priority(2)
public class Cat implements Animal {
    @Override
    public void use() {
        System.out.println("猫 【" + Cat.class.getSimpleName() + " ) 是抓老鼠 。");
    }
}
