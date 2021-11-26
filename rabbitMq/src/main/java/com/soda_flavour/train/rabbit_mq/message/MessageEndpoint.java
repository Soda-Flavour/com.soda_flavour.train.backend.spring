package com.soda_flavour.train.rabbit_mq.message;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageEndpoint {
    

    @RabbitListener(queues = "${com.soda_flavour.train.rabbit_mq.inbound}")
    public void inboundQueueHandle(Map<String, Object> payload) {
        
    }


    
    
}
