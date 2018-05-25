package com.wosyx.demo.client;

import com.wosyx.demo.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/8 10:03
 */
public class DemoClient {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:motan-client.xml");
        HelloService fooService = (HelloService) applicationContext.getBean("helloService");
        while(true) {
            try {
                System.out.println(fooService.hello("world"));
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
