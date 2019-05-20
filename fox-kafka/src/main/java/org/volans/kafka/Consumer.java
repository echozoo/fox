package org.volans.kafka;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-05-18
 * @since JDK1.8
 */
@Component
public class Consumer {

  private final List<Message> messages = new CopyOnWriteArrayList<>();

  @KafkaListener(topics = "testTopic")
  public void processMessage(Message message) {
    this.messages.add(message);
    System.out.println("Received sample message [" + message + "]");
  }

  List<Message> getMessages() {
    return this.messages;
  }
}
