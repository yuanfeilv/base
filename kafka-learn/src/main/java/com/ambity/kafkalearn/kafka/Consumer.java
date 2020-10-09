package com.ambity.kafkalearn.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Consumer {
    // batchFactory 为批量消费拉取注册的bean
    @KafkaListener(topics = {"test"},containerFactory= "batchFactory")
    public void listenPlayEnt(List<ConsumerRecord<String, String>> records, Acknowledgment acknowledgment){
        for (ConsumerRecord<String, String> record : records){
            System.out.println(record.topic()+"收到消息" + record.value());
            record.offset();
            if ("88".equals(record.value())){
                acknowledgment.acknowledge();
            }
        }
//        acknowledgment.acknowledge();
//        throw new RuntimeException("'22");
    }
}
