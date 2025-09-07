package com.echozoo.foxlottery.controller;

import com.echozoo.foxlottery.po.Activity;
import com.echozoo.foxlottery.po.LotteryParam;
import com.echozoo.foxlottery.po.LotteryResult;
import com.echozoo.foxlottery.service.ActivityService;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dujf
 */
@RestController
@RequestMapping("/activity")
@RefreshScope
public class ActivityController {


    @Resource
    private ActivityService activityService;

    @Value("${test.key}")
    private String testkey;

    @GetMapping("/list")
    public List<Activity> list() {
        System.out.println( testkey);
        return activityService.list();
    }

    @GetMapping("/init")
    public Boolean save() {
        return activityService.save();
    }


    @PostMapping("/lottery")
    public LotteryResult lottery(@RequestBody LotteryParam param) {
        return activityService.lottery(param);
    }

}
