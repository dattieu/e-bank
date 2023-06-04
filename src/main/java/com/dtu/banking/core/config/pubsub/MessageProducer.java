package com.dtu.banking.core.config.pubsub;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@AllArgsConstructor
public class MessageProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendAsync(String topicName, String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message).completable();
        future.whenComplete((result, ex) -> {
            if (Objects.isNull(ex)) {
                log.info("Successfully sent message={} to topic={}", message, topicName);
            } else {
                log.error("Unable to send message={} due to {}", message, ex.getMessage());
            }
        });
    }

    public void send(String topicName, String message) {
        log.info("Sent message={} to topic={}", message, topicName);
        kafkaTemplate.send(topicName, message);
    }
}
