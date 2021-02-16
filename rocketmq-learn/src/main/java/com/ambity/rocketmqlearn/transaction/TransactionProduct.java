package com.ambity.rocketmqlearn.transaction;


import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author ambity
 */
@Component
public class TransactionProduct {
    @Autowired
    RocketMQTemplate rocketMQTemplate;
    public String sendTransaction(String topic,String tag,String messageData){
        Message<String> message = MessageBuilder.withPayload(messageData).build();
        String destination =topic+":"+tag;
        rocketMQTemplate.sendMessageInTransaction(destination,message,destination);
        return "";
    }
}
