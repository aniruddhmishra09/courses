package com.courses.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

@Slf4j
public class SimpleConsumerWithShutdown {

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


        final Thread mainThread = Thread.currentThread();

        //Create Consumer
        try(KafkaConsumer<String,String > consumer = new KafkaConsumer<>(properties)){

            Runtime.getRuntime().addShutdownHook(new Thread(){
                @Override
                public void run(){
                    log.info("Shutdown detected, exiting the consumer polling");
                    consumer.wakeup();

                    //Joining the main thread to allow completion of the execution in main thread
                    try {
                        mainThread.join();
                    } catch (InterruptedException e) {
                        log.error("Interrupt Exception - {}", e.getMessage());
                        throw new RuntimeException(e);
                    }
                }
            });

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
        }catch (WakeupException we){
            //Suppressing exception as this is an expected exception in case of Shutdown
            log.info("Consumer is shutting down");
        }catch (Exception ex){
            log.info("Error while Consuming Message from Kafka", ex);
        }

    }
}
