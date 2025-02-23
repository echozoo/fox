package com.echozoo.foxlottery.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @Author: ddd
 * @Date: 2023/11/13
 */
@Configuration
@ConfigurationProperties(prefix = "test")
@RefreshScope
public class TestConfig {

    private String key;
    private Integer value;

}
