package com.echozoo.foxlottery;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@MapperScan("com.echozoo.foxlottery.repository")
@NacosPropertySource(dataId = "${nacos.config.data-id}", autoRefreshed = true)
public class FoxLotteryApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoxLotteryApplication.class, args);
    }

}
