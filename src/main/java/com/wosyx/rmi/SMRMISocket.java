package com.wosyx.rmi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/14 10:12
 */
public class SMRMISocket extends RMISocketFactory {

    private final int port;

    public SMRMISocket(int port) {
        this.port = port;
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        return new Socket(host, port);
    }

    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        if (port == 0) {
            port = this.port;
        }
        return new ServerSocket(port);
    }
}
