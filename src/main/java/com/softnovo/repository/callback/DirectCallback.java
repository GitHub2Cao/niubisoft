package com.softnovo.repository.callback;

public class DirectCallback {
    class Request {
        public void send(InvokeCallback.CallBack callBack) throws Exception {
            // 模拟等待响应
            Thread.sleep(3000);
            System.out.println("[Request]:收到响应");
            callBack.processResponse();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DirectCallback directCallback = new DirectCallback();
        final Request request = directCallback.new Request();
        System.out.println("发送请求");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    request.send(new InvokeCallback.CallBack());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("请求已经发送");
        Thread.sleep(10 * 1000);
    }
}
