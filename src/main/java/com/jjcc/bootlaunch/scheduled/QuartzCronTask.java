package com.jjcc.bootlaunch.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

/**
 * quartz的任务类
 * @author Jjcc
 * @version 1.0.0
 * @className QuartzCronTask.java
 * @createTime 2019年10月30日 21:39:00
 */
@Slf4j
public class QuartzCronTask extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        log.info("quartz的cron任务: " + LocalDateTime.now());
    }
}
