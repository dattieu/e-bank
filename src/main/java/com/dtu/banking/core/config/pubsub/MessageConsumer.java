package com.dtu.banking.core.config.pubsub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageConsumer {

    @KafkaListener(topics = Topics.CUSTOMER_CREATED, groupId = Topics.CUSTOMER_CREATED_GROUP)
    public void consume(String message) {
        log.info("Message consumed successfully -> {}", message);
    }

}
