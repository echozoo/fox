package org.volans.kafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.volans.kafka.Content;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Future;

/**
 * @author dujf
 * @version 1.0
 * @date 2022/12/22 18:13
 */
@Service
@Log4j2
public class KafkaStreamService {

    @Autowired
    private KafkaProducer<String, String> kafkaProducer;

    private final String COIN_MARKET_API = "https://v1.hitokoto.cn/";
    private final String KAFKA_STREAM = "mk-group-test";
    private final ObjectMapper mapper = new ObjectMapper();

    public void produce() {
        final HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(COIN_MARKET_API)).build();
        final HttpResponse<String> send;
        try {
            send = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return;
        }

        ProducerRecord<String, String> record = new ProducerRecord<>(KAFKA_STREAM, send.body());
        final Future<RecordMetadata> future = kafkaProducer.send(record, (recordMetadata, e) -> {
            if (null != e) {
                log.info("e = " + e.getLocalizedMessage(), e);
            }

            log.info("recordMetadata:{},{},{}" + recordMetadata.topic(), "====", recordMetadata.serializedValueSize());
        });
    }


    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    public void testKafkaStream(KStream<Object, Object> stream) {
        stream.foreach((k, v) -> {
            log.info("k={},v={}", k, v);
        });

//        final KStream<String, Content> kStream = stream
//                .filter((k, v) -> v != null)
//                .mapValues(it -> {
//                    final Content content;
//                    try {
//                        content = mapper.readValue(it.toString(), Content.class);
//                    } catch (IOException e) {
//                        log.info("反序列化异常：{}", e.getLocalizedMessage(), e);
//                        return null;
//                    }
//
//                    return content;
//                }).filter((k, v) -> null != v)
//                .map((k, v) -> KeyValue.pair(v.getId().toString(), v));


        final KTable<String, Long> count = stream.groupBy((k, v) -> v.toString()).count();

        count.toStream().foreach((k, v) -> {
            log.info("k = {},v = {}", k, v);
        });
    }

}
