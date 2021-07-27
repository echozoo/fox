package com.echozoo.grpc.controller;

import com.echozoo.grpc.FooClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * grpc 服务端和客户端测试
 *
 * @author dujf
 * @version 1.0
 * @date 2021/7/24 0:05
 */

@RequestMapping("foo")
@RestController
public class FooController {

    private Logger logger = LoggerFactory.getLogger(FooController.class);

    @Autowired
    private FooClient fooClient;


    @GetMapping("test")
    public String test(String name) {
        logger.info("Will try to request {}", name);
        final String foo = fooClient.listFoo(name);
        logger.info("response: {}", foo);
        return foo;
    }
}
