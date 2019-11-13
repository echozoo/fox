package org.volans.scheduler.service;

import org.volans.scheduler.entity.JobInfo;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author j
 * @since 2019-11-12
 */
public interface JobInfoService extends IService<JobInfo> {

    void create(JobInfo jobInfo);

}
