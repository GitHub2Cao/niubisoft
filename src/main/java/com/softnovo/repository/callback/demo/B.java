package com.softnovo.repository.callback.demo;

public class B {
    public void b(A a) {
        System.out.println("now in b");
        System.out.println("b method finished!!!");
        a.callback();
    }
}
