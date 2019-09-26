package org.volans.test;

import java.util.concurrent.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;

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

  @Autowired
  private ExecutorService executorService;

  @RequestMapping
  public void foo() {
    for (int i = 0; i < 5; i++) {
      executorService.execute(new Runnable() {
        @Override public void run() {
          System.out.println("12345689");
        }
      });
    }
  }

}
