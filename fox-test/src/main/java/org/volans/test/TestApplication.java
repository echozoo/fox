package org.volans.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @author dujf
 * 自定义配置文件
 */
@SpringBootApplication
@PropertySource(value = { "classpath:abc.properties" }, encoding = "utf-8")
public class TestApplication {

  public static void main(String[] args) {
    SpringApplication.run(TestApplication.class, args);
    String lines = "-----------------------------------------------";
    System.out.println(String.format("%s\nhttp://localhost:8010/swagger-ui.html\n%s", lines, lines));
  }

}
