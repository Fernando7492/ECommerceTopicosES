package com.topicos.storage.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.topicos.storage.config.RabbitMQConfig;

@Component
public class MessageConsumer {
    @Autowired
    private StockService stockService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(@Payload String message) {
        System.out.println("print!!!!" + message);
        Long productId = Long.parseLong(message.trim());

        stockService.createStocksForNewProduct(productId);
    }
}