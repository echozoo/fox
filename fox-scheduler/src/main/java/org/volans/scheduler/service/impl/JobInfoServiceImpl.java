package org.volans.scheduler.service.impl;

import org.quartz.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.volans.scheduler.entity.JobInfo;
import org.volans.scheduler.mapper.JobInfoMapper;
import org.volans.scheduler.service.JobInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author j
 * @since 2019-11-12
 */
@Service
public class JobInfoServiceImpl extends ServiceImpl<JobInfoMapper, JobInfo> implements JobInfoService {

    private final JobInfoMapper mapper;

    @Autowired public JobInfoServiceImpl(JobInfoMapper mapper) {this.mapper = mapper;}

    @Override public void create(JobInfo jobInfo) {
        if (!CronExpression.isValidExpression(jobInfo.getCorn())) {
            return;
        }
        JobInfo info = new JobInfo();
        info.setCorn("1 0 0 0 0");
        info.setName("hello world");
        info.setStatus(1);
        mapper.insert(info);
    }

}
