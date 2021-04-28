package com.softnovo.repository.callback;

import java.lang.reflect.Method;

public class InvokeCallback {
    class Request {
        public void send(Class clazz, Method method) throws Exception {
            Thread.sleep(3000);
            System.out.println("收到响应");
            method.invoke(clazz.newInstance());
        }
    }

    static class CallBack {
        public void processResponse() {
            System.out.println("响应处理");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final InvokeCallback invokeCallback = new InvokeCallback();
        final Request request = invokeCallback.new Request();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    request.send(CallBack.class, CallBack.class.getMethod("processResponse"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println("请求发送完成");
        Thread.sleep(1000 * 1000);
    }
}
