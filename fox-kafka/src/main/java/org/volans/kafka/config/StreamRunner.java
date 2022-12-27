package org.volans.kafka.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.volans.kafka.service.KafkaStreamService;

import java.util.Properties;

/**
 * 初始化流
 *
 * @author dujf
 * @version 1.0
 * @date 2022/12/27 15:24
 */
@Slf4j
@Component
public class StreamRunner implements CommandLineRunner {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    @Autowired
    private KafkaStreamService kafkaStreamService;

    private final String KAFKA_STREAM = "mk-group-test";


    @Override
    public void run(String... args) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-app-test-1234");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());

        StreamsBuilder builder = new StreamsBuilder();
        final KStream<Object, Object> stream = builder.stream(KAFKA_STREAM);

        log.info("===========stream start==========");
        try {

            kafkaStreamService.testKafkaStream(stream);
        } catch (Exception e) {
            log.info("流处理异常：{}", e.getLocalizedMessage(), e);
        }
        final Topology topology = builder.build();
        final KafkaStreams streams = new KafkaStreams(topology, props);
        streams.start();
        log.info("===========stream start success==========");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            streams.close();
            log.info("===========stream close success==========");
        }));
    }
}
