package org.volans.scheduler.service.impl;

import javax.annotation.Resource;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.stereotype.Component;
import org.volans.scheduler.entity.JobInfo;

import static org.quartz.JobBuilder.newJob;

/**
 * @author <a href="http://github.com/athc">j</a>
 * @date 2019-11-12
 * @since JDK1.8
 */
@Component
public class QuartzManager {

    @Resource(name = "scheduler")
    private Scheduler scheduler;

    public void addJob(JobInfo job) throws SchedulerException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //通过类名获取实体类，即要执行的定时任务的类
        Class<?> clazz = Class.forName(job.getName());
        Job jobEntity = (Job) clazz.newInstance();
        //通过实体类和任务名创建 JobDetail
        JobDetail jobDetail = newJob(jobEntity.getClass())
            .withIdentity(job.getName())
            .build();
        //通过触发器名和cron 表达式创建 Trigger
        Trigger cronTrigger = TriggerBuilder.newTrigger()
            .withIdentity(job.getName())
            .startNow()
            .withSchedule(CronScheduleBuilder.cronSchedule(job.getCorn()))
            .build();
        //执行定时任务
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    /**
     * 更新job cron表达式
     *
     * @param jobInfo
     * @throws SchedulerException
     */
    public void updateJobCron(JobInfo jobInfo) throws SchedulerException {

        TriggerKey triggerKey = TriggerKey.triggerKey(jobInfo.getName());
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(jobInfo.getCorn());
        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
        scheduler.rescheduleJob(triggerKey, trigger);
    }

    /**
     * 删除一个job
     *
     * @param jobInfo
     * @throws SchedulerException
     */
    public void deleteJob(JobInfo jobInfo) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobInfo.getName());
        scheduler.deleteJob(jobKey);
    }

    /**
     * 恢复一个job
     *
     * @param jobInfo
     * @throws SchedulerException
     */
    public void resumeJob(JobInfo jobInfo) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobInfo.getName());
        scheduler.resumeJob(jobKey);
    }

    /**
     * 立即执行job
     *
     * @param jobInfo
     * @throws SchedulerException
     */
    public void runAJobNow(JobInfo jobInfo) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobInfo.getName());
        scheduler.triggerJob(jobKey);
    }

    /**
     * 暂停一个job
     *
     * @param jobInfo
     * @throws SchedulerException
     */
    public void pauseJob(JobInfo jobInfo) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobInfo.getName());
        scheduler.pauseJob(jobKey);
    }
}
