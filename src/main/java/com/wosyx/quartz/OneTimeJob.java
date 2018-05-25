package com.wosyx.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/23 11:51
 */
public class OneTimeJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("OneTimeJob:"+new Date() + ": doing something...");
    }
}

