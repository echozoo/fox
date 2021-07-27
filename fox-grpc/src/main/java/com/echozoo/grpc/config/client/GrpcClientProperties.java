package com.echozoo.grpc.config.client;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * grpc 客户端配置
 *
 * @author dujf
 * @version 1.0
 * @date 2021/7/27 10:36
 */

@ConfigurationProperties(prefix = "grpc.client")
public class GrpcClientProperties {

    private String host;

    private Integer port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
