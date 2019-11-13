package org.volans.scheduler.task;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Task implements Job {

    private Logger logger = LoggerFactory.getLogger(Task.class);

    @Override public void execute(JobExecutionContext jobExecutionContext) {
        logger.info("hello world!!!!");
    }
}

