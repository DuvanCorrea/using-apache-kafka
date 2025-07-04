package com.kafka.prueba_kafka.config.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @KafkaListener(topics = "ping", groupId = "prueba-group")
    public void listener(String message) {
        logger.info("Mensaje leido con el consumer: {}", message);
    }


}
