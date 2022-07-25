package com.echozoo.fox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;


@SpringBootApplication
@RestController
public class FoxWebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoxWebfluxApplication.class, args);
    }


    @GetMapping("/test/{name}")
    Flux<String> files(@PathVariable String name) {
        return Flux.fromIterable(List.of("hello world"));
    }
}
