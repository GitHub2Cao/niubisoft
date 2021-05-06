package com.softnovo.aop;


/**
 * @author cgm
 */
public class HelloServiceimpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if (name == null || name.trim() == "") {
            throw new RuntimeException("parameter is null !!");
        }
        System.out.println("hello  " + name);
    }
}
