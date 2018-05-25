package com.wosyx.spring;

import com.wosyx.rmi.IRmi;
import com.wosyx.rmi.RmiManager;
import com.wosyx.rmi.SMRMISocket;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/14 12:01
 */
public class RmiServer {
    static IRmi rmi;
    public static void main(String[] args) throws IOException {
//        System.setProperty("java.security.policy", policyFile);
        System.setProperty("java.rmi.server.hostname", "139.199.186.211");
//        new ClassPathXmlApplicationContext("spring-server.xml");

        String host = "139.199.186.211";
        int port = 9080;
        int cmport = 9088;
        String serverName = "test";
        RMISocketFactory.setSocketFactory(new SMRMISocket(cmport));
        rmi = new RmiManager();
        String url = String.format("rmi://%s:%d/%s", host, port, serverName);
        LocateRegistry.createRegistry(port);
        Naming.rebind(url, rmi);
    }
}
