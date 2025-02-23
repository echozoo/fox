package com.echozoo.foxlottery.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: TODO
 * @Author: ddd
 * @Date: 2023/11/13
 */
@Data
@TableName("activity")
public class Activity {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "活动名称")
    private String title;
    @ApiModelProperty(value = "活动描述")
    @TableField("`desc`")
    private String desc;
}
