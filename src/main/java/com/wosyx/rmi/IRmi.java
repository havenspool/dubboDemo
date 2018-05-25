package com.wosyx.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/14 10:17
 */
public interface IRmi extends Remote {
    int queryBalance(String mobileNo) throws RemoteException;
    String shoopingPayment(String mobileNo, byte protocol) throws RemoteException;
}
