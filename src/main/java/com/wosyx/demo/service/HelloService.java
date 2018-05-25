package com.wosyx.demo.service;

import com.weibo.api.motan.transport.async.MotanAsync;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/8 10:04
 */
@MotanAsync
public interface HelloService {
    String hello(String world);
}
