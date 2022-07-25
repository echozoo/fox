package com.echozoo.fox;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class FoxWebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoxWebfluxApplication.class, args);
        log.info("接口文档地址：{}", "http://localhost:8000/swagger-ui/index.html");
    }

}
