package com.softnovo.service.message;

import com.softnovo.domain.message.DemoMessage;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(
        topic = DemoMessage.TOPIC,
        consumerGroup = "demo01-consumer-group-" + DemoMessage.TOPIC
)
public class Consumer implements RocketMQListener<DemoMessage> {
    @Override
    public void onMessage(DemoMessage demoMessage) {
        System.out.println("[onMessage][线程编号:{} 消息内容：{}] == " +  Thread.currentThread().getId() + " == " + demoMessage);
    }
}
