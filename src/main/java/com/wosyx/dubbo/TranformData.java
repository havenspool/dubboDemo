package com.wosyx.dubbo;

import java.io.Serializable;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/5/25 17:19
 */
public class TranformData implements Serializable {

    public TranformData(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    /** 符文ID（符文id*1000+品质） */
    public int getId(){
        return this.id;
    }

    private String name;
    /** 物品名称 */
    public String getName(){
        return this.name;
    }
}
