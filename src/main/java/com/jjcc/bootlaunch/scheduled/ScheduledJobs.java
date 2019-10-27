package com.jjcc.bootlaunch.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务类
 * @author Jjcc
 * @version 1.0.0
 * @className ScheduledJobs.java
 * @createTime 2019年10月27日 21:16:00
 */
@Slf4j
@Component
public class ScheduledJobs {

    /**
     * 表示方法执行完成后5秒再执行
     * @title fixedDelayJob
     * @author Jjcc
     * @return void
     * @createTime 2019/10/27 21:18
     */
    @Scheduled(fixedDelay = 5000)
    public void fixedDelayJob() {
        String name = Thread.currentThread().getName();
        log.info(name + "：fixedDelayJob定时任务执行");
        log.info("fixedDelayJob--------------------");
    }

    /**
     * 表示方法每隔5秒执行一次；当指定的时间内任务没有执行完成，任务执行完成后会再次执行
     * @title fixedRateJob
     * @author Jjcc
     * @return void
     * @createTime 2019/10/27 21:20
     */
    @Scheduled(fixedRate = 5000)
    public void  fixedRateJob() {
        String name = Thread.currentThread().getName();
        log.info(name + "：fixedRateJob定时任务执行");
        log.info("fixedRateJob--------------------");
    }

    /**
     * 表示每隔20秒执行一次
     * @title cronJob
     * @author Jjcc
     * @return void
     * @createTime 2019/10/27 21:24
     */
    @Scheduled(cron = "0/20 * * * * ?")
    public void cronJob() {
        String name = Thread.currentThread().getName();
        log.info(name + "：cronJob定时任务执行");
        log.info("cronJob--------------------");
    }
}
