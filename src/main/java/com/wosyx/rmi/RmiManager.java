package com.wosyx.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/14 15:24
 */
public class RmiManager extends UnicastRemoteObject implements IRmi{
    public RmiManager() throws RemoteException {
    }

    @Override
    public int queryBalance(String mobileNo) throws RemoteException{
        if (mobileNo != null)
            return 100;
        return 0;
    }

    @Override
    public String shoopingPayment(String mobileNo, byte protocol) throws RemoteException{
        StringBuffer sb = new StringBuffer().append("Your mobile number is /").append(mobileNo).append("/, protocol type is /").append(protocol).append("/.");
        System.out.println("Message is: " + sb.toString());
        return sb.toString();
    }
}
