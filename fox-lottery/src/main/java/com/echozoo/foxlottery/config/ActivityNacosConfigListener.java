package com.echozoo.foxlottery.config;

import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author: ddd
 * @Date: 2023/11/13
 */
@Slf4j
@Component
public class ActivityNacosConfigListener {

    @Resource
    private TestConfig config;

    @NacosConfigListener(dataId = "${nacos.config.data-id}", groupId = "DEFAULT_GROUP")
    public void onChange(String newConfig) {
        log.info("Nacos 配置变更了，新的配置内容：\n{}", newConfig);
        log.info("test config：\n{}", config);
    }

}
