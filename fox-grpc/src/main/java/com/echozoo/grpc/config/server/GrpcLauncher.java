package com.echozoo.grpc.config.server;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * grpc 服务
 *
 * @author dujf
 * @version 1.0
 * @date 2021/7/25 22:39
 */

@Component
@Import(GrpcServerProperties.class)
public class GrpcLauncher {

    private final Logger logger = LoggerFactory.getLogger(GrpcLauncher.class);


    /**
     * 定义Grpc Server
     */
    private Server server;

    private final GrpcServerProperties properties;

    public GrpcLauncher(GrpcServerProperties properties) {
        this.properties = properties;
    }

    /**
     * GRPC 服务启动方法
     *
     * @param grpcServiceMap
     */
    public void grpcStart(Map<String, Object> grpcServiceMap) {
        var port = properties.getPort();
        try {
            var serverBuilder = ServerBuilder.forPort(port);
            for (Object bean : grpcServiceMap.values()) {
                serverBuilder.addService((BindableService) bean);
                logger.info("{} is register in Spring Boot", bean.getClass().getSimpleName());
            }
            server = serverBuilder.build().start();
            logger.info("grpc server is started at {}", port);
            server.awaitTermination();
            Runtime.getRuntime().addShutdownHook(new Thread(this::grpcStop));
        } catch (IOException | InterruptedException e) {
            logger.info("grpc 启动失败信息：{}", e.getLocalizedMessage(), e);
        }
    }

    /**
     * GRPC 服务Stop方法
     */
    private void grpcStop() {
        if (server != null) {
            server.shutdownNow();
        }
    }

}