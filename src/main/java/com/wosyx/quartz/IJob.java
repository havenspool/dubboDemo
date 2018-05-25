package com.wosyx.quartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/23 15:49
 */
@DisallowConcurrentExecution
public abstract class IJob implements Job {
}
