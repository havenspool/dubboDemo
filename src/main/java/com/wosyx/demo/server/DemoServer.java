package com.wosyx.demo.server;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/8 10:03
 */
public class DemoServer {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:motan-server.xml");
        MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
        System.out.println("Server start ...");
    }
}
