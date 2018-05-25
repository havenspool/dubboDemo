package com.wosyx.dubbo;

import com.wosyx.utils.PropertyUtil;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/14 16:26
 */
public class DubboClient {
    public static void main(String[] args) throws Exception {
        PropertyUtil.loadProps("server");
        PropertyUtil.loadProps("mysql");

//        String driver = PropertyUtil.getProperty("jdbc.driverClassName");
//        String url = PropertyUtil.getProperty("jdbc.url");
//        String user = PropertyUtil.getProperty("jdbc.user");
//        String passwd = PropertyUtil.getProperty("jdbc.password");
//
//        Map<String, String> map = MysqlUtil.getMysqlConfig(driver, url, user, passwd);
//        String dubboServerPort = map.get("dubboServerPort");
//        String dubboClientPort = map.get("dubboClientPort");
//        PropertyUtil.setProperty("dubboServerPort", dubboServerPort);
//        PropertyUtil.setProperty("dubboClientPort", dubboClientPort);

        String dubboServerPort = PropertyUtil.getProperty("dubboServerPort");
        String dubboClientPort = PropertyUtil.getProperty("dubboClientPort");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-client.xml"});
        context.start();
        // press any key to exit
//        System.in.read();
        //192.168.28.55    139.199.186.211
        ClassPathXmlApplicationContext server = new ClassPathXmlApplicationContext(new String[]{"dubbo-context.xml"});


        String clientUrl1 = "dubbo://192.168.28.55:"+dubboClientPort + "/" + DubboService.class.getName();
        String clientUrl2 = "dubbo://192.168.28.55:"+dubboClientPort + "/" + DubboTestService.class.getName();
        RealReference realReference = new RealReference();

        realReference.register(clientUrl1, server, DubboService.class, DubboService.class.getName());
        realReference.register(clientUrl2, server, DubboTestService.class, DubboTestService.class.getName());

        DubboService serverService = (DubboService)realReference.get(DubboService.class.getName()).getObject();
        DubboTestService dubboTestService = (DubboTestService)realReference.get(DubboTestService.class.getName()).getObject();

//        String serverUrl = "dubbo://192.168.28.55:"+dubboServerPort + DubboService.class.getName();//更改不同的Dubbo服务暴露的ip地址&端口
//        RealReference.realReference(serverUrl, server, DubboService.class);
//        DubboService serverService = (DubboService)RealReference.get(DubboService.class.getName());

//        String clientUrl = "dubbo://192.168.28.55:"+dubboClientPort + DubboService.class.getName();//更改不同的Dubbo服务暴露的ip地址&端口
//        serverService.register(1, clientUrl);

        // obtain proxy object for remote invocation
//        DubboService serverService = (DubboService) context.getBean("serverService");

        // execute remote invocation
        String hello = serverService.sayHello("world");
        // show the result
        System.out.println(hello);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String hello2 = serverService.sayHello("world");
        // show the result
        System.out.println(hello2);

        TranformData tranformData = new TranformData(1, "2");
        dubboTestService.tanform(1, tranformData);

    }
}
