package com.example.servicea;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 5000) // Отправлять сообщение каждые 5 секунд
    public void sendMessage() {
        try {
            kafkaTemplate.send("alive-topic", "I'm alive").get(); // Блокирует до подтверждения отправки
            System.out.println("Message sent: I'm alive");
        } catch (Exception e) {
            System.err.println("Error sending message: " + e.getMessage());
        }
    }
}
