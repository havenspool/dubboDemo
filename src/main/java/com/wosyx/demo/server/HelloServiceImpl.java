package com.wosyx.demo.server;

import com.wosyx.demo.service.HelloService;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/8 10:04
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String world) {
        return "hello " + world;
    }
}
