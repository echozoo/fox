package com.echozoo.foxrabiitmq;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySource(dataId = "${nacos.config.data-id}", autoRefreshed = true)
@EnableRabbit
public class FoxRabiitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoxRabiitmqApplication.class, args);
    }

}
