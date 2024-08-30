package com.topicos.storage.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topicos.storage.config.RabbitMQConfig;

@Service
public class MessageConsumer {
    @Autowired
    private StockService stockService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        String[] parts = message.split(": ");
        Long productId = Long.parseLong(parts[1].trim());
        
        stockService.createStocksForNewProduct(productId);
    }
}