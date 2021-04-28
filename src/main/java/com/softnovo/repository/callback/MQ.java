package com.softnovo.repository.callback;

public class MQ {
    class Producer{
        public void send(String msg, MsgStateCallback msgStateCallback) {
            System.out.println("send msg :" + msg);
            int ACK = 1;
            if (ACK == 0) {
                msgStateCallback.succ();
            } else {
                msgStateCallback.fail();
            }
        }
    }

    interface MsgStateCallback{
        void succ();
        void fail();
    }

    public static void main(String[] args) {
        MQ mq = new MQ();
        Producer producer = mq.new Producer();
        String msg = "my msg";
        producer.send(msg, new MsgStateCallback() {
            @Override
            public void succ() {
                System.out.println("消息发送成功");
            }

            @Override
            public void fail() {
                System.out.println("消息发送失败");
            }
        });
    }

}
