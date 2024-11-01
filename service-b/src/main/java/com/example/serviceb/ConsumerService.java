package com.example.serviceb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    private final MessageRepository messageRepository;

    public ConsumerService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @KafkaListener(topics = "${kafka.topic.alive}", groupId = "group_id")
    public void listen(String message) {
        logger.info("Kafka Listener triggered"); // Логируем вызов слушателя

        logger.info("Received message: {}", message); // Логируем полученное сообщение

        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setTimestamp(LocalDateTime.now());
        messageEntity.setMessage(message);
        messageRepository.save(messageEntity);

        logger.info("Saved message at {}: {}", LocalDateTime.now(), message); // Логируем, что сообщение сохранено
    }
}
