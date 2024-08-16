package org.example;

import java.util.Properties;

public class KafkaConfig {
    private static final String BOOTSTRAP_SERVERS = "localhost:9092";
    private static final String GROUP_ID = "test-group";
    private static final String KEY_DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer";
    private static final String VALUE_DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer";
    private static final String AUTO_OFFSET_RESET = "latest";
    private static final String TOPIC = "test-topic";

    public static Properties getConsumerProperties() {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", BOOTSTRAP_SERVERS);
        properties.setProperty("group.id", GROUP_ID);
        properties.setProperty("key.deserializer", KEY_DESERIALIZER);
        properties.setProperty("value.deserializer", VALUE_DESERIALIZER);
        properties.setProperty("auto.offset.reset", AUTO_OFFSET_RESET);
        return properties;
    }

    public static Properties getProducerProperties() {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", BOOTSTRAP_SERVERS);
        properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return properties;
    }

    public static String getTopic() {
        return TOPIC;
    }
}