package com.softnovo.ioc;

import org.springframework.stereotype.Component;

import javax.annotation.Priority;

/**
 * @author cgm
 */
@Component
@Priority(3)
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("狗 【" + Dog.class.getSimpleName() + "】是看 门用的 。 ");
    }
}
