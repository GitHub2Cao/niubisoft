package com.softnovo.repository.callback.demo;

public class A {
    private B b = new B();

    private void a() {
        b.b(this);
    }

    public void callback() {
        System.out.println("a callback");
    }

    public static void main(String[] args) {
        A a = new A();
        a.a();
    }
}
