package com.echozoo.foxlottery.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.echozoo.foxlottery.po.Activity;
import com.echozoo.foxlottery.po.LotteryParam;
import com.echozoo.foxlottery.po.LotteryResult;
import com.echozoo.foxlottery.po.Prize;
import com.echozoo.foxlottery.repository.ActivityMapper;
import com.echozoo.foxlottery.repository.PrizeMapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @author dujf
 */
@Service
public class ActivityServiceImpl implements ActivityService {


    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private PrizeMapper prizeMapper;

    @Override
    public List<Activity> list() {
        return activityMapper.selectList(new QueryWrapper<>(new Activity()));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean save() {
        Activity activity = new Activity();
        activity.setId(1L);
        activity.setTitle("ddd-抽奖活动1");
        activity.setDesc("ddd-抽奖活动1");

        List<Prize> prizeList = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            Prize prize = new Prize();
            prize.setActivityId(activity.getId().toString());
            prize.setPrizeName("奖品" + i);
            prize.setPrizeNum(new Random().nextInt(100));
            prize.setPrizeType(1);
            prize.setPosition(List.of(i));
            prize.setUsedNum(0);
            prize.setProbability(new Random().nextInt(100));
            prizeList.add(prize);
            prizeMapper.insert(prize);
        }

        return activityMapper.insert(activity) > 0;
    }

    @Override
    public LotteryResult lottery(LotteryParam param) {
        LotteryResult result = new LotteryResult();
        result.setWin(false);
        List<Prize> prizeList = prizeMapper.selectList(
                new QueryWrapper<Prize>().eq("activity_id", param.getActivityId()));
        if (CollectionUtils.isEmpty(prizeList)) {
            return result;
        }

        Long prize = PrizeDrawUtils.findPrize(prizeList);
        if (null == prize) {
            return result;
        }

        //


        return result;
    }
}
