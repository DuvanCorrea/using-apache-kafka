package com.kafka.prueba_kafka.config.provider;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic(){

        Map<String,String> configurations = new HashMap<>();

        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000");
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");
        //configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "");

        return TopicBuilder.name("topic-desde-spring-boot")
                .partitions(1)
                .replicas(1)
                .configs(configurations)
                .build();
    }

}
