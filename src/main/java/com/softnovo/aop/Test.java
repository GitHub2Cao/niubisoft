package com.softnovo.aop;

public class Test {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceimpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new Myinterceptor(true));
        proxy.sayHello("aaaaa");
    }
}
