package com.topicos.storage.services;

import com.topicos.storage.config.RabbitMQConfig;
import com.topicos.storage.create.CreateStock;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    @Autowired
    private CreateStock stockService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(@Payload String message) {
        Long productId;

        try {
            productId = Long.parseLong(message.trim());
        } catch (NumberFormatException e) {
            System.err.println("Invalid product ID received: " + message);
            return;
        }
        stockService.createStocksForNewProduct(productId).subscribe();
    }
}
