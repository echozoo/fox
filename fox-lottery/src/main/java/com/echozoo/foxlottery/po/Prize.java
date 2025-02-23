package com.echozoo.foxlottery.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.annotations.ApiModelProperty;
import java.beans.Transient;
import java.lang.reflect.Type;
import java.util.List;
import lombok.Data;

/**
 * @Description: TODO
 * @Author: ddd
 * @Date: 2023/11/13
 */
@Data
@TableName("prize")
public class Prize {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "奖品名称")
    private String prizeName;
    @ApiModelProperty(value = "奖品类型")
    private Integer prizeType;
    @ApiModelProperty(value = "奖品数量")
    private Integer prizeNum;
    @ApiModelProperty(value = "已中奖数量")
    private Integer usedNum;
    @ApiModelProperty(value = "已中奖数量")
    private Integer probability;
    @ApiModelProperty(value = "位置信息")
    private String position;

    private String activityId;

    private transient ObjectMapper objectMapper = new JsonMapper();

    public void setPosition(List<Integer> param) {
        try {
            this.position = objectMapper.writeValueAsString(param);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getPositionList() {
        return objectMapper.convertValue(this.position, new TypeReference<>() {
        });
    }
}
