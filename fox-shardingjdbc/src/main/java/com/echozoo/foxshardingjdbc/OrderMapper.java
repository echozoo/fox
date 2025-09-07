package com.echozoo.foxshardingjdbc;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Description: TODO
 * @Author: ddd
 * @Date: 2023/11/13
 */
@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO t_order(order_id, user_id, status) VALUES(#{orderId}, #{userId}, #{status})")
    void insert(TOrderPO order);

    @Select("SELECT * FROM t_order WHERE order_id = #{orderId}")
    TOrderPO selectByOrderId(Long orderId);
}
