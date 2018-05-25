package com.wosyx.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/14 13:42
 */
public class RmiClient {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-client.xml");
        AccountService accountService = (AccountService) ctx.getBean("mobileAccountService");
        String result = accountService.shoopingPayment("13800138000", (byte) 5);
        System.out.println(result);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result2 = accountService.shoopingPayment("13800138000", (byte) 5);
        System.out.println(result2);

    }
}
