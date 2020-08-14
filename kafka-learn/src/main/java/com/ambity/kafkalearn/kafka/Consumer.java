package com.ambity.kafkalearn.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Consumer {
    // batchFactory 为批量消费拉取注册的bean
    @KafkaListener(topics = {"docker"},containerFactory= "batchFactory")
    public void listenPlayEnt(List<ConsumerRecord<String, String>> records){
        System.out.println(records.get(0).topic()+"收到消息" + records.size()+"--"+records.get(0).value());
    }
}
