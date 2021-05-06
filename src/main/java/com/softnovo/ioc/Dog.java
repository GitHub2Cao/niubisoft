package com.softnovo.ioc;

import org.springframework.stereotype.Component;

/**
 * @author cgm
 */
@Component
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("狗 【" + Dog.class.getSimpleName() + "】是看 门用的 。 ");
    }
}
