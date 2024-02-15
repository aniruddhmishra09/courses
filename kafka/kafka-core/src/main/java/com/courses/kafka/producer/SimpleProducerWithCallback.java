package com.courses.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class SimpleProducerWithCallback {

    public static void main(String[] args) {
        log.info("Entering Kafka Producer with Callback");
        String topic = "core-kafka-2";
        String message = topic +"-"+ ThreadLocalRandom.current().nextInt(11);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","127.0.0.1:9092");

        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());


        try(KafkaProducer<String, String> producer = new KafkaProducer<>(properties);){
            ProducerRecord<String, String> record = new ProducerRecord<>(topic,  message);
            log.info("Before Sending Message to Kafka Topic - {} & Message - {}",topic, message);
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e==null){
                        log.info("Message Successfully Sent to Topic");
                        log.info("Message metadata details | Topic - {} | Partition - {} | Offset - {}  | Timestamp - {}",
                                recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), recordMetadata.timestamp());
                    }else {
                        log.error("Error Caught in Callback while Publishing Message " , e);
                    }
                }
            });
            log.info("After Sending Message to Kafka Topic - {} & Message - {}",topic,message);
        }catch (Exception ex){
            log.error("Error while publishing message",ex);
        }

        log.info("Exiting Kafka Producer with Callback");
    }
}
