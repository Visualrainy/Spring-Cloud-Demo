package com.spring.cloud.person.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    //kafka-console-consumer --bootstrap-server localhost:9092 --topic firstKafkaMessage --from-beginning
    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message) throws Exception {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
}
