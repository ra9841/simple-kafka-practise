package com.rabin.kafkaconsumer.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {


    @KafkaListener(topics="rabin-demo",groupId = "rabin-group-1") //from config of producer & consumer
    public void consumerEvents(String message){
        log.info("consumer consume the message {}", message);
    }

    //In real time it is not good to write code like this. Or having number of consumer

//    @KafkaListener(topics="rabin-demo",groupId = "rabin-group-1") //from config of producer & consumer
//    public void consumerEvents1(String message){
//        log.info("consumer1 consume the message {}", message);
//    }
//    @KafkaListener(topics="rabin-demo",groupId = "rabin-group-1") //from config of producer & consumer
//    public void consumerEvents2(String message){
//        log.info("consumer2 consume the message {}", message);
//    }
//    @KafkaListener(topics="rabin-demo",groupId = "rabin-group-1") //from config of producer & consumer
//    public void consumerEvents3(String message){
//        log.info("consumer3 consume the message {}", message);
//    }



}
