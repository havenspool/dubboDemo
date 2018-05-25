package com.wosyx.rmi;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/14 10:12
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String host = "192.168.28.55";
        int port = 9001;
        String serverName = "test";
        IRmi rmi = null;
        RMISocketFactory.setSocketFactory(new SMRMISocket(9001));
        String url = String.format("rmi://%s:%d/%s", new Object[] { host, port, serverName});
        LocateRegistry.createRegistry(port);
        Naming.rebind(url, rmi);


    }
}
