package com.rabin.kafkaproducer.service;



public interface KafkaMessagePublisherService {
    void sendMessageToTopic(String message);


}
