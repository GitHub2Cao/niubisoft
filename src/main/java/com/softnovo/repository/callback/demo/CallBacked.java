package com.softnovo.repository.callback.demo;

public class CallBacked {
    public void a() {
        CallBacker callBacker = new CallBacker();
        callBacker.b(new CallBackUnit() {
            @Override
            public void callbackFunc() {
                System.out.println("end back!!!");
            }
        });

        callBacker.b(() -> System.out.println("so good"));
    }

    public static void main(String[] args) {
        CallBacked callBacked = new CallBacked();
        callBacked.a();
    }
}
