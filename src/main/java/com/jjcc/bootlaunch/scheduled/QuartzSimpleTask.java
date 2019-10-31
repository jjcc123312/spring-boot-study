package com.jjcc.bootlaunch.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

/**
 * quartz定时任务；任务类
 * @author Jjcc
 * @version 1.0.0
 * @className QuartzSimpleTask.java
 * @createTime 2019年10月30日 10:02:00
 */
@Slf4j
public class QuartzSimpleTask extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        log.info("quartz简单的定时任务：" + LocalDateTime.now());
    }
}
