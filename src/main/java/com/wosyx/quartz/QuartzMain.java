package com.wosyx.quartz;

import java.util.Date;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/20 18:32
 */
public class QuartzMain {

    public static String JOB_NAME = "动态任务调度";
    public static String TRIGGER_NAME = "动态任务触发器";
    public static String JOB_GROUP_NAME = "XLXXCC_JOB_GROUP";
    public static String TRIGGER_GROUP_NAME = "XLXXCC_JOB_GROUP";

    public static void main(String[] args) {
        try {
            Date date = new Date();
            date.setMinutes(20);
            date.setSeconds(0);
            QuartzManager.addOneJob("one", OneTimeJob.class, date);

            System.out.println("【系统启动】开始(每3秒输出一次)...");
            QuartzManager.addJob(JOB_NAME, MyJob.class, "0/3 * * * * ?");

//            Thread.sleep(5000);
//            System.out.println("【修改时间】开始(每5秒输出一次)...");
//            QuartzManager.modifyJobTime(JOB_NAME, "0/5 * * * * ?");
//
//            Thread.sleep(6000);
//            System.out.println("【移除定时】开始...");
//            QuartzManager.removeJob(JOB_NAME);
//            System.out.println("【移除定时】成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
