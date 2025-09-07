package com.echozoo.foxshardingjdbc;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.UUID;
import me.ahoo.cosid.snowflake.SecondSnowflakeId;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @javax.annotation.Resource
    private OrderMapper orderMapper;

    @PostMapping("/test/insert")
    public void inset(){
        for (int i = 0; i < 100; i++) {
            TOrderPO tOrderPO = new TOrderPO();
            tOrderPO.setStatus("PENDING");
            tOrderPO.setUserId(i);
            tOrderPO.setOrderId((long)i);
            orderMapper.insert(tOrderPO);
        }
    }
}
