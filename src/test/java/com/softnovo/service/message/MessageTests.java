package com.softnovo.service.message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageTests {
    @Resource
    private Producer producer;
    @Resource
    private Consumer consumer;

    @Test
    public void producer() {
        producer.syncSend(100);

        try {
            new CountDownLatch(1).await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//    @Test
//    public void consumer() {
//        consumer.onMessage();
//    }
}
