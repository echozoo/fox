package com.echozoo.grpc.config.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.concurrent.TimeUnit;

/**
 * grpc client 配置
 *
 * @author dujf
 * @version 1.0
 * @date 2021/7/25 16:33
 */
@Configuration
@Import(GrpcClientProperties.class)
public class GrpcClientConfig {


    /**
     * message channel
     *
     * @param properties
     * @return io.grpc.ManagedChannel
     * @author dujf
     * @date 2021/7/27 11:00
     * @since java 11
     */
    @Bean
    ManagedChannel channel(GrpcClientProperties properties) {
        return ManagedChannelBuilder.forAddress(properties.getHost(), properties.getPort())
                .usePlaintext()
                .disableRetry()
                .idleTimeout(2, TimeUnit.SECONDS)
                .build();
    }
}
