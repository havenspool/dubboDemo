package com.wosyx.sofa;

import com.alipay.sofa.rpc.config.ConsumerConfig;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/20 10:33
 */
public class QuickStartClient {
    public static void main(String[] args) {
        ConsumerConfig<HelloService> consumerConfig = new ConsumerConfig<HelloService>()
                .setInterfaceId(HelloService.class.getName()) // 指定接口
                .setProtocol("bolt") // 指定协议
                .setDirectUrl("bolt://127.0.0.1:9696"); // 指定直连地址
        // 生成代理类
        HelloService helloService = consumerConfig.refer();
        while (true) {
            System.out.println(helloService.sayHello("world"));
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }
        }
    }
}
