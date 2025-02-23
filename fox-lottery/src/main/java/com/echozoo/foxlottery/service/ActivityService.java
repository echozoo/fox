package com.echozoo.foxlottery.service;

import com.echozoo.foxlottery.po.Activity;
import com.echozoo.foxlottery.po.LotteryParam;
import com.echozoo.foxlottery.po.LotteryResult;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

public interface ActivityService {

    List<Activity> list();

    Boolean save();

    LotteryResult lottery(LotteryParam param);

}
