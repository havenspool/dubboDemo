package com.wosyx.dubbo;

import com.alibaba.dubbo.config.ProtocolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * @desc: TODO
 * @author: havens
 * @date: 2018/4/16 9:47
 */
public class DynamicConfiguration {
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 这个方法返回Runnable只是一个幌子，最重要的是执行方法里面的代码
     */
    @Bean
    public Runnable dynamicConfiguration() throws Exception
    {
        ConfigurableApplicationContext context = (ConfigurableApplicationContext)applicationContext;
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)context.getBeanFactory();

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(ProtocolConfig.class);
        int port = 9050;
        beanDefinitionBuilder.addPropertyValue("name", "dubbo");
        beanDefinitionBuilder.addPropertyValue("port", port);

        /**
         * 注册到spring容器中
         */
        beanFactory.registerBeanDefinition("dubbo", beanDefinitionBuilder.getBeanDefinition());
        return null;
    }
}
