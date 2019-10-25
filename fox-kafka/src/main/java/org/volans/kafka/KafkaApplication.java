package org.volans.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dujf
 */
@SpringBootApplication
@RestController
public class KafkaApplication {

    @Bean
    public NewTopic kafkaTestTopic() {
        return new NewTopic("testTopic", 10, (short) 2);
    }

    @Bean
    public ApplicationRunner runner(Producer producer) {
        Message message = new Message();
        message.setContent("content");
        message.setTitle("title");
        return (args) -> producer.send(message);
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @Autowired
    private Producer producer;


    @PostMapping
    public void send() {
        Message message = new Message();
        message.setContent("content");
        message.setTitle("title");
        producer.send(message);
    }
}
