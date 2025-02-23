package com.echozoo.foxlottery.po;


import lombok.Data;

/**
 * @Description: TODO
 * @Author: ddd
 * @Date: 2023/11/13
 */
@Data
public class LotteryDTO {

    Integer probability;
    Long prizeId;
    Integer from;
    Integer to;
}
