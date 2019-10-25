package org.volans.kafka;

import lombok.Data;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-05-18
 * @since JDK1.8
 */
public class Message {
  private String title;
  private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
