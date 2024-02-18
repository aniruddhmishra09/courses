package com.courses.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;

@Slf4j
public class SimpleProducer {

    public static void main(String[] args) {
        log.info("Entering Kafka Producer");
        String topic = "core-kafka-1";

        //Connection Properties
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","127.0.0.1:9092");
        //Producer Properties
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        try(KafkaProducer<String, String> producer = new KafkaProducer<>(properties);){
            //Creating Kafka Message Record
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, "MyValue");
            log.info("Before Sending Message to Kafka Topic - {}",topic);
            //Publishing Kafka Message
            producer.send(record);
            log.info("After Sending Message to Kafka Topic - {}",topic);
        }catch (Exception ex){
            log.error("Error while publishing message",ex);
        }

        log.info("Exiting Kafka Producer");
    }
}
