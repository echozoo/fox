package com.echozoo.foxrabiitmq.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author: ddd
 * @Date: 2023/11/13
 */
@RestController()
@RequestMapping("/producer")
@Slf4j
public class ProducerController {

    @Resource
    private AmqpTemplate amqpTemplate;
    @Resource
    private AmqpAdmin amqpAdmin;

    @GetMapping("/send")
    public void send() {
        // 创建交换机
        amqpAdmin.declareExchange(new DirectExchange("test-exchange"));
        // 创建队列
        amqpAdmin.declareQueue(new Queue("test-queue"));
        // 声明绑定关系
        // 绑定交换机和队列
        // 绑定路由键
        amqpAdmin.declareBinding(
                new Binding("test-queue", DestinationType.QUEUE, "test-exchange",
                        "test-routingKey",
                        null));
        // 发送消息
        amqpTemplate.convertAndSend("test-exchange", "test-routingKey", "hello,rabbit~");
        log.info("消息发送成功:{}", "hello,rabbit~");
    }

    @NacosValue(value = "${rabbitmq.test}", autoRefreshed = true)
    private String commonTest;

    @GetMapping("/get")
    public String getCommonTest() {
        return commonTest;
    }

    @PostConstruct
    private void init() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    MDC.put("reqId", UUID.randomUUID().toString());
                    log.info("commonTest:{}", commonTest);
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        new Thread(runnable).start();

    }
}
