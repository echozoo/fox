package com.echozoo.foxshardingjdbc;

import org.apache.shardingsphere.spring.boot.ShardingSphereAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.echozoo.foxshardingjdbc")
public class FoxShardingjdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoxShardingjdbcApplication.class, args);
    }

}
