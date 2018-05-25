package com.wosyx.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/16 11:22
 */
public class MysqlUtil {
    public static Map<String, String> getMysqlConfig(String driver, String url, String user, String passwd) {
        Map<String, String> map = new HashMap<>();
        Connection con;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,passwd);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            Statement statement = con.createStatement();
            String sql = "select * from tb_config";
            ResultSet rs = statement.executeQuery(sql);
            String key;
            String value;
            while(rs.next()){
                key = rs.getString("key");
                value = rs.getString("value");
                //输出结果
                System.out.println(key + "\t" + value);
                map.put(key, value);
            }
            rs.close();
            con.close();
        } catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
