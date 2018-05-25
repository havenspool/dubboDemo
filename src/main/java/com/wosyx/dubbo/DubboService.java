package com.wosyx.dubbo;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/14 16:23
 */
public interface DubboService extends IService{
    String sayHello(String name);
    void register(int serverId, String url, Class clazz, String className);
    String sayHi(String name);
}
