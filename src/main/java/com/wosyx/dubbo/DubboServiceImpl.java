package com.wosyx.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/14 16:23
 */
public class DubboServiceImpl implements DubboService{
    public String sayHello(String name) {
        System.out.println("Hello " + name);
        DubboServer.servers.values().stream().forEach(realReference -> {
            ((DubboService)realReference.get(DubboService.class.getName())).sayHi("server");
        });
        return "Hello " + name;
    }

    @Override
    public void register(int serverId, String url, Class clazz, String className) {
        RealReference realReference = new RealReference();
        realReference.register(url, new ClassPathXmlApplicationContext(new String[]{"dubbo-context.xml"}), clazz, className);
        DubboServer.servers.put(serverId, realReference);
    }

    @Override
    public String sayHi(String name) {
        System.out.println("Hi " + name);
        return "Hi " + name;
    }
}
