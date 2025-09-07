package com.echozoo.foxshardingjdbc;

import lombok.Data;

/**
 * @Description: TODO
 * @Author: ddd
 * @Date: 2023/11/13
 */
@Data
public class TOrderPO {
    private Long orderId;
    private Integer userId;
    private String status;
}
