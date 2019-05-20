package org.volans.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-05-18
 * @since JDK1.8
 */
@Component
public class Producer {

  private final KafkaTemplate<Object, Message> kafkaTemplate;

  Producer(KafkaTemplate<Object, Message> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void send(Message message) {
    this.kafkaTemplate.send("testTopic", message);
    System.out.println("Sent sample message [" + message + "]");
  }
}
