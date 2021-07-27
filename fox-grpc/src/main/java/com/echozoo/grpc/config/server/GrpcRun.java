package com.echozoo.grpc.config.server;

import com.echozoo.grpc.anotation.GrpcService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 启动时注册grpc服务
 *
 * @author dujf
 * @version 1.0
 * @date 2021/7/27 10:18
 */
@Component
public class GrpcRun implements CommandLineRunner {

    private final ApplicationContext context;

    public GrpcRun(ApplicationContext context) {
        this.context = context;
    }


    /**
     * 启动注册grpc服务
     *
     * @param args
     * @return void
     * @author dujf
     * @date 2021/7/27 11:01
     * @since java 11
     */
    @Override
    public void run(String... args) {
        var grpcServiceMap = context.getBeansWithAnnotation(GrpcService.class);
        var launcher = context.getBean(GrpcLauncher.class);
        launcher.grpcStart(grpcServiceMap);
    }
}
