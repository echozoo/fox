package org.volans.scheduler.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.volans.scheduler.mapper.JobInfoMapper;

/**
 * @author <a href="http://github.com/athc">j</a>
 * @date 2019-11-13
 * @since JDK1.8
 */
@Service
public class ScheduleServiceImpl {

    @Autowired
    private JobInfoMapper jobInfoMapper;

    @Autowired
    private QuartzManager quartzManager;

    public void add() {
        jobInfoMapper.selectList(new EntityWrapper<>()).forEach(it -> {
            try {
                quartzManager.addJob(it);
            } catch (SchedulerException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void delete() {
        jobInfoMapper.selectList(new EntityWrapper<>()).forEach(it -> {
            try {
                quartzManager.deleteJob(it);
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        });
    }
}
