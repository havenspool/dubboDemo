package com.wosyx.spring;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/14 11:59
 */
public interface AccountService {
    int queryBalance(String mobileNo);
    String shoopingPayment(String mobileNo, byte protocol);
}
