package com.wosyx.sofa;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/20 10:32
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String string) {
        System.out.println("Server receive: " + string);
        return "hello " + string + " ！";
    }
}
