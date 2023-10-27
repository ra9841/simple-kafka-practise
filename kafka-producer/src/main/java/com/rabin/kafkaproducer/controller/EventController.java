package com.rabin.kafkaproducer.controller;


import com.rabin.kafkaproducer.service.KafkaMessagePublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class EventController {

    @Autowired
    private KafkaMessagePublisherService kafkaMessagePublisherService;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message) {
        try {
            for (int i = 0; i <= 1000; i++) {
                kafkaMessagePublisherService.sendMessageToTopic(message + ":"+ i);
            }
            return ResponseEntity.ok("message published successfully.........");

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }



}
