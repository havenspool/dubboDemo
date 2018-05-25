package com.wosyx.dubbo;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/5/25 17:24
 */
public class DubboTestServiceImpl implements DubboTestService{
    public boolean tanform(int serverId, TranformData tranformData){
        System.out.println(tranformData.getId()+":"+tranformData.getName());
        return true;
    }
}
