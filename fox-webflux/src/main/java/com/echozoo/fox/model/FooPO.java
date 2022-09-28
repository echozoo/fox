package com.echozoo.fox.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author dujf
 * @version 1.0
 * @date 2022/7/25 11:16
 */
@Data
@Accessors(chain = true)
public class FooPO {
    private String _id;
    private String contactType;
    private String name;
    /**
     * 模拟命名不规范
     */
    private String createUserID;
    private Integer expireDay;
    private String expireTime;
    private Boolean enable;
    private String link;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer status;

    public static FooPO buildPO() {
        final LocalDateTime now = LocalDateTime.now();
        return new FooPO().set_id(UUID.randomUUID().toString())
                .setContactType("1")
                .setName("张晓二测试")
                .setCreateUserID("122")
                .setExpireDay(10)
                .setExpireTime(now.toString())
                .setEnable(Boolean.TRUE)
                .setLink("www.baidu.com")
                .setCreateTime(now)
                .setUpdateTime(now)
                .setStatus(1)
                ;
    }
}
