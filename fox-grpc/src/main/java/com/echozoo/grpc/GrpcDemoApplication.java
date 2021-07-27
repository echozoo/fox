package com.echozoo.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication(scanBasePackages = {"com.echozoo.grpc"})
public class GrpcDemoApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(GrpcDemoApplication.class, args);
    }
}
