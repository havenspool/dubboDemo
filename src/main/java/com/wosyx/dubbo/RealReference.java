package com.wosyx.dubbo;

import com.alibaba.dubbo.config.spring.ReferenceBean;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/14 17:10
 */
public class RealReference {

    public Map<String, ReferenceBean> map = new HashMap<>();

    public void register(String url, ApplicationContext applicationContext, Class clazz, String className) {
        try {
            ReferenceBean<IService> referenceBean = new ReferenceBean<>();
            referenceBean.setInterface(clazz);
            referenceBean.setUrl(url);
            referenceBean.setApplicationContext(applicationContext);
            referenceBean.afterPropertiesSet();
            map.put(className, referenceBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ReferenceBean get(String className){
        return map.get(className);
    }
}
