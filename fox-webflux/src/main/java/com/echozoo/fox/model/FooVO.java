package com.echozoo.fox.model;

import lombok.Data;


/**
 * @author dujf
 * @version 1.0
 * @date 2022/7/25 11:16
 */
@Data
public class FooVO {
    private String id;
    private String contactType;
    private String name;
    private String createUserId;
    private Integer expireDay;
    private String expireTime;
    private Boolean enable;
    private String link;
    private String createTime;
    private String updateTime;
    private Integer status;
}
