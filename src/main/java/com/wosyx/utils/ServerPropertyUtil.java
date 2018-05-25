package com.wosyx.utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/16 11:56
 */
public class ServerPropertyUtil{
    private static PropertiesConfiguration props = new PropertiesConfiguration();
    public static String path;

    synchronized static private void loadProps(){
        System.out.println("开始加载properties文件内容.......");
        try {
//            String profilepath = PropertyUtil.class.getResource("/").getPath()+ path + ".properties";
//            props  = new PropertiesConfiguration(profilepath);
            props.load(path + ".properties");  //配置文件名称:config.properties
        } catch (ConfigurationException e) {
            e.printStackTrace();
            System.out.println("properties文件未找到");
        }
        System.out.println("加载properties文件内容完成...........");
        System.out.println("properties文件内容：" + props);
    }

    synchronized static private void saveProp(String key, String value){
        props.setAutoSave(true);
        props.setProperty(key, value);
        System.out.println("属性文件更新成功：" + key + ":" + value);
    }

    public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        return props.getString(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getString(key, defaultValue);
    }

    public static void setProperty(String key, String value) {
        if(null == props) {
            loadProps();
        }
        saveProp(key, value);
    }
}
