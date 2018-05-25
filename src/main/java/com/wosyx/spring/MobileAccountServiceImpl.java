package com.wosyx.spring;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/14 11:59
 */
public class MobileAccountServiceImpl implements AccountService {
    public int queryBalance(String mobileNo) {
        if (mobileNo != null)
            return 100;
        return 0;
    }

    public String shoopingPayment(String mobileNo, byte protocol) {
        StringBuffer sb = new StringBuffer().append("Your mobile number is /").append(mobileNo).append("/, protocol type is /").append(protocol).append("/.");
        System.out.println("Message is: " + sb.toString());
        return sb.toString();
    }
}
