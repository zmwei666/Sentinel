package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


@Configuration
public class NacosConfig {

    @Bean
    public ConfigService nacosConfigService(NacosPropertiesConfiguration nacosPropertiesConfiguration) throws Exception {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, nacosPropertiesConfiguration.getServerAddr());
        properties.put(PropertyKeyConst.NAMESPACE, nacosPropertiesConfiguration.getNamespace());
        properties.put(PropertyKeyConst.USERNAME,nacosPropertiesConfiguration.getUsername());
        properties.put(PropertyKeyConst.PASSWORD,nacosPropertiesConfiguration.getPassword());
        return ConfigFactory.createConfigService(properties);
    }
}