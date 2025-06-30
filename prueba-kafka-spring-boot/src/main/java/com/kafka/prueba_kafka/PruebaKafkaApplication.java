package com.kafka.prueba_kafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class PruebaKafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(PruebaKafkaApplication.class, args);
    }

    @Bean
    CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
            // Usas cuando quieras callback sin bloquear
            kafkaTemplate
                    .send("ping", "Hola mundo! APLICAION SPRING BOOT INICIO " + System.currentTimeMillis())
                    .whenComplete((r, ex) -> {
                        if (ex != null) System.err.println("Error: " + ex.getMessage());
                        else System.out.println("Enviado offset " + r.getRecordMetadata().offset());
                    })
                    .get(10, TimeUnit.SECONDS); // opcional: bloquear para salir solo tras el envío
        };
    }

}
