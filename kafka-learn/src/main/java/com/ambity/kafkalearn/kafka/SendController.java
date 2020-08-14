package com.ambity.kafkalearn.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {
    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("/send")
    public void send(@RequestParam String message){
        kafkaTemplate.send("docker","11",message);
    }
}
