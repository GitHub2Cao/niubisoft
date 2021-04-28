package com.softnovo.service.message;

import com.softnovo.domain.message.DemoMessage;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("producer")
public class Producer {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public SendResult syncSend(Integer id) {
        // 创建 Demo01Message 消息
        DemoMessage message = new DemoMessage();
        message.setId(id);
        // 同步发送消息
        return rocketMQTemplate.syncSend(DemoMessage.TOPIC, message);
    }

//    public void asyncSend(Integer id, SendCallback callback) {
//        // 创建 Demo01Message 消息
//        Demo01Message message = new Demo01Message();
//        message.setId(id);
//        // 异步发送消息
//        rocketMQTemplate.asyncSend(Demo01Message.TOPIC, message, callback);
//    }
//
//    public void onewaySend(Integer id) {
//        // 创建 Demo01Message 消息
//        Demo01Message message = new Demo01Message();
//        message.setId(id);
//        // oneway 发送消息
//        rocketMQTemplate.sendOneWay(Demo01Message.TOPIC, message);
//    }
}
