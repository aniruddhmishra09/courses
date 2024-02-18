package com.courses.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Slf4j
public class SimpleConsumer {

    public static void main(String[] args) {
        log.info("Entering Kafka Consumer");

        String groupId = "core-kafka-group-1";
        String topic = "core-kafka-2";

        //Connection Properties
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","127.0.0.1:9092");
        //Creating Kafka Consumer Properties
        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer", StringDeserializer.class.getName());
        properties.setProperty("group.id",groupId);
        properties.setProperty("auto.offset.reset","earliest");

        //Create Consumer
        try(KafkaConsumer<String,String > consumer = new KafkaConsumer<>(properties)){
            //Subscribe to Kafka Topic
            consumer.subscribe(List.of(topic));

            //Consumer Data from Kafka Topic
            while (true){
                log.info("Polling Kafka Topic");
                ConsumerRecords<String,String> records = consumer.poll(Duration.ofMillis(1000));

                //Printing Kafka Message
                records.forEach(record ->{
                    log.info("Key - {} | Value - {}",record.key(), record.value());
                    log.info("Partition - {} | Offset - {}",record.partition(), record.offset());
                });

            }
        }catch (Exception ex){
            log.info("Error while Consuming Message from Kafka", ex);
        }

    }
}
