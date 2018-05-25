package com.wosyx.dubbo;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/5/25 17:24
 */
public interface DubboTestService extends IService{
    boolean tanform(int serverId, TranformData tranformData);
}
