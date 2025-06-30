package com.kafka.prueba_kafka.config.provider;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Scanner;

@Component
public class ConsoleKafkaProducer implements ApplicationRunner {

    private final KafkaTemplate<String,String> kafkaTemplate;
    public ConsoleKafkaProducer(KafkaTemplate<String,String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Kafka Producer Shell ===");
        System.out.println("Escribe mensajes para enviarlos a 'ping'. Para salir, escribe 'exit'.");
        String line;
        while (true) {
            System.out.print("ESCRIBIR DESDE PROVUDER >>> ");
            line = scanner.nextLine();
            if ("exit".equalsIgnoreCase(line.trim())) {
                System.out.println("Saliendo del producer shell.");
                break;
            }
            kafkaTemplate.send("ping", line);
        }
        scanner.close();
    }
}
