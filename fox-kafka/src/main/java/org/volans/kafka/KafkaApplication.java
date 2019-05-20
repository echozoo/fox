package org.volans.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author dujf
 */
@SpringBootApplication
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

}
