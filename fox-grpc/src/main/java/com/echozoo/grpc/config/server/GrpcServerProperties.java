package com.echozoo.grpc.config.server;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * grpc 客户端配置
 *
 * @author dujf
 * @version 1.0
 * @date 2021/7/27 10:36
 */
@Configuration
@ConfigurationProperties(prefix = "grpc.server")
public class GrpcServerProperties {

    private Integer port;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
