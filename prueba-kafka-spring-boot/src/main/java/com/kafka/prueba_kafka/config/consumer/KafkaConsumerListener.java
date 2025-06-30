package com.kafka.prueba_kafka.config.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;


@Configuration
public class KafkaConsumerListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = {"topic-desde-spring-boot"}, groupId = "grupo-spring")
    public void listener(String message) {
        logger.info("Mensaje recibido: " + message);
    }

}
