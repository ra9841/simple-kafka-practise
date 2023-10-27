package com.rabin.kafkaproducer.service;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class KafkaMessagePublisherServiceImpl implements KafkaMessagePublisherService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void sendMessageToTopic(String message) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("rabin-demo", message);  //rabin-demo-1 name from config class
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message=[" + message + "]with offset=[" + result.getRecordMetadata().offset() + "]with partition=[" + result.getRecordMetadata().partition()+"]");
            } else {
                log.info("Unable to send message=[" + message , "] due to :" + ex.getMessage());
            }
        });

    }
}
