package com.wosyx.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/23 11:03
 */
public class QuartzManager {
    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    public static void addOneJob(String jobName, Class jobClass, Date dateTime) {
        try {
            schedulerFactory.getScheduler().scheduleJob(JobBuilder.newJob(jobClass).withIdentity(jobName).build(), TriggerBuilder.newTrigger().startAt(dateTime).build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description: 添加一个定时任务
     * @param jobName 任务名
     * @param jobClass  任务
     * @param cron   时间设置，参考quartz说明文档
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void addJob(String jobName, Class jobClass, String cron) {
        try {
            // 任务名，任务组，任务执行类
            JobDetail jobDetail= JobBuilder.newJob(jobClass).withIdentity(jobName).build();
            // 触发器
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            // 触发器名,触发器组
            triggerBuilder.withIdentity(jobName);
            triggerBuilder.startNow();
            // 触发器时间设定
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
            schedulerFactory.getScheduler().scheduleJob(jobDetail, triggerBuilder.build());
            // 启动
            if (!schedulerFactory.getScheduler().isShutdown()) {
                schedulerFactory.getScheduler().start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description: 修改一个任务的触发时间
     * @param cron   时间设置，参考quartz说明文档
     */
    public static void modifyJobTime(String jobName, String cron) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName);
            CronTrigger trigger = (CronTrigger) schedulerFactory.getScheduler().getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }

            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(cron)) {
                /** 方式一 ：调用 rescheduleJob 开始 */
                // 触发器
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组
                triggerBuilder.withIdentity(jobName);
                triggerBuilder.startNow();
                // 触发器时间设定
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
                // 方式一 ：修改一个任务的触发时间
                schedulerFactory.getScheduler().rescheduleJob(triggerKey, triggerBuilder.build());
                /** 方式一 ：调用 rescheduleJob 结束 */

                /** 方式二：先删除，然后在创建一个新的Job  */
                //JobDetail jobDetail = sched.getJobDetail(JobKey.jobKey(jobName, jobGroupName));
                //Class<? extends Job> jobClass = jobDetail.getJobClass();
                //removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
                //addJob(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, cron);
                /** 方式二 ：先删除，然后在创建一个新的Job */
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description: 移除一个任务
     * @param jobName
     */
    public static void removeJob(String jobName) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName);

            schedulerFactory.getScheduler().pauseTrigger(triggerKey);// 停止触发器
            schedulerFactory.getScheduler().unscheduleJob(triggerKey);// 移除触发器
            schedulerFactory.getScheduler().deleteJob(JobKey.jobKey(jobName));// 删除任务
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:启动所有定时任务
     */
    public static void startJobs() {
        try {
            schedulerFactory.getScheduler().start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:关闭所有定时任务
     */
    public static void shutdownJobs() {
        try {
            if (!schedulerFactory.getScheduler().isShutdown()) {
                schedulerFactory.getScheduler().shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
