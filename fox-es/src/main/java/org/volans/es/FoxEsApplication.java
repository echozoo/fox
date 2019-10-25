package org.volans.es;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * todo: 需要完成的注释
 * NOTE: 提示
 * XXX: @author dujf
 * fixme: 需要修复
 * HACK: 替人背锅
 * BUG: 虫子
 */
@SpringBootApplication
@EnableSwagger2Doc
public class FoxEsApplication {

  public static void main(String[] args) {
    SpringApplication.run(FoxEsApplication.class, args);
    String lines = "==========================";
    System.out.println(lines + "\nhttp://127.0.0.1:8010/swagger-ui.html\n" + lines);
  }

}
