package com.softnovo.ioc;

import org.springframework.stereotype.Component;

import javax.annotation.Priority;

/**
 * @author cgm
 */
@Component
@Priority(1)
public class Pig implements Animal {
    @Override
    public void use() {
        System.out.println("猪 【" + Dog.class.getSimpleName() + "】是吃 。 ");
    }
}
