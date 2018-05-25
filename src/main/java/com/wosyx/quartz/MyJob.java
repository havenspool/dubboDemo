package com.wosyx.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;
import java.util.Random;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/23 11:04
 */
public class MyJob extends IJob {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            Random random = new Random();
            int time = 1000+ random.nextInt(5000);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyJob:"+ new Date() + ": doing something...");
    }
}
