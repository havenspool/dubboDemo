package com.wosyx.dubbo;

import com.alibaba.dubbo.config.ProtocolConfig;
import com.wosyx.utils.PropertyUtil;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/14 16:25
 */
public class DubboServer {

    public static Map<Integer, RealReference> servers = new HashMap<>();

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
//        PropertyUtil.setProperty("dubboServerPort", dubboServerPort);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dubbo-server.xml"});

        context.start();
        // press any key to exit


        Map<String, ProtocolConfig> beansOfType = context.getBeansOfType(ProtocolConfig.class);
        for (Map.Entry<String, ProtocolConfig> item : beansOfType.entrySet()) {
//            port = NetUtils.getAvailablePort();
            System.out.println("##################use sure###########################"+item.getValue().getPort());
//            item.getValue().setPort(port);
        }


        int i = System.in.read();
        System.out.println("print:" + i + ":"+(i == 49));
        if(i == 49){
            DubboServer.servers.values().stream().forEach(realReference -> {
                ((DubboService)realReference.get(DubboService.class.getName())).sayHi("server");
            });
        }
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        //消费者
//        DubboService serverService = (DubboService) context.getBean("clientService");
//        // execute remote invocation
//        String hello = serverService.sayHello("world");
//        // show the result
//        System.out.println(hello);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        String hello2 = serverService.sayHello("world");
//        // show the result
//        System.out.println(hello2);
    }
}
