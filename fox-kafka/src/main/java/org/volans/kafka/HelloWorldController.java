package org.volans.kafka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="http://github.com/athc">j</a>
 * @date 2019-10-31
 * @since JDK1.8
 */

@RestController
@RequestMapping("kafka-stream")
public class HelloWorldController {


    @Autowired
    private AdminClient client;


    @GetMapping("send")
    public void producer() throws ExecutionException, InterruptedException {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-application");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        producer.send(new ProducerRecord<>(testHelloWorld, content));
        producer.close();
    }

    @GetMapping
    public void helloWorld() throws ExecutionException, InterruptedException {
        Collection<NewTopic> topics = new ArrayList<>();
        ListTopicsResult res = client.listTopics();
        if (!res.names().get().contains("trade"))
            topics.add(new NewTopic("trade", 1, Short.parseShort("1")));
        if (!res.names().get().contains("WordsWithCountsTopic"))
            topics.add(new NewTopic("WordsWithCountsTopic", 1, Short.parseShort("1")));
        CreateTopicsResult result = client.createTopics(topics);
        result.all().get();
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-application");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        logger.info("创建topic {}", topics);
        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> textLines = builder.stream(testHelloWorld);
        KTable<String, Long> wordCounts = textLines
            .flatMapValues(
                textLine -> Arrays.asList(textLine.toLowerCase().split("\\W+"))
            )
            .groupBy(
                (key, word) -> word
            )
            .count(Materialized.as("counts-store"));
        wordCounts.toStream().to(wordsWithCountsTopic, Produced.with(Serdes.String(), Serdes.Long()));
        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();
    }

    @GetMapping("count")
    public void count() throws ExecutionException, InterruptedException {
        Collection<NewTopic> topics = new ArrayList<>();
        ListTopicsResult res = client.listTopics();
        if (!res.names().get().contains(wordsWithCountsTopic)) {
            topics.add(new NewTopic(wordsWithCountsTopic, 1, Short.parseShort("1")));
        }
        client.createTopics(topics);


        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-application");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        StreamsBuilder builder = new StreamsBuilder();

//        KStreamBuilder builder = ...;  // when using the Kafka Streams DSL
//
// OR
//
//        TopologyBuilder builder = ...; // when using the Processor API

// Use the configuration to tell your application where the Kafka cluster is,
// which serializers/deserializers to use by default, to specify security settings,
// and so on.
//        StreamsConfig config = ...;


        KStream<String, Long> counts = builder.stream(wordsWithCountsTopic);
        counts.foreach(
            (k, v) -> System.out.println(k + ":" + v)
        );
        KafkaStreams streams = new KafkaStreams(builder.build(), props);


//        topics.stream().flatMap(x)


        streams.start();
    }

    private String content = "all streams lead to kafka\\nhello kafka streams\\njoin kafka summit";

    private String testHelloWorld = "test-hello-world";

    private String wordsWithCountsTopic = "WordsWithCountsTopic";

    private Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
}
