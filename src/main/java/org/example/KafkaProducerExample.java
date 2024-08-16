package org.example;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerExample {
    public static void main(String[] args) {
        Properties properties = KafkaConfig.getProducerProperties();

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {
            for (int i = 0; i < 10; i++) {
                ProducerRecord<String, String> record = new ProducerRecord<>(KafkaConfig.getTopic(), "key" + i, "value " + i);
                producer.send(record, (metadata, exception) -> {
                    if (exception != null) exception.printStackTrace();
                     else {
                        System.out.printf("Sent message with key %s to partition %d with offset %d%n",
                                record.key(), metadata.partition(), metadata.offset());
                    }
                });
            }
            producer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}