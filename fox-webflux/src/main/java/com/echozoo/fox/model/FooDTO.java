package com.echozoo.fox.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 *
 * @author dujf
 * @version 1.0
 * @date 2022/7/25 11:16
 */
@Data
public class FooDTO {
    private String id;
    private String contactType;
    private String name;
    private String createUserId;
    private Integer expireDay;
    private String expireTime;
    private Boolean enable;
    private String link;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer status;
}
