package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Properties;

/**
 * @author Eric Zhao
 * @since 1.4.0
 */
@Configuration
public class NacosConfig {

    @Bean
    public Converter<List<FlowRuleEntity>, String> flowRuleEntityEncoder() {
        return JSON::toJSONString;
    }

    @Bean
    public Converter<String, List<FlowRuleEntity>> flowRuleEntityDecoder() {
        return s -> JSON.parseArray(s, FlowRuleEntity.class);
    }

    @Bean
    public ConfigService nacosConfigService(NacosPropertiesConfiguration nacosPropertiesConfiguration) throws Exception {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, nacosPropertiesConfiguration.getServerAddr());
        properties.put(PropertyKeyConst.NAMESPACE, nacosPropertiesConfiguration.getNamespace());
        properties.put(PropertyKeyConst.USERNAME,nacosPropertiesConfiguration.getUsername());
        properties.put(PropertyKeyConst.PASSWORD,nacosPropertiesConfiguration.getPassword());
        return ConfigFactory.createConfigService(properties);
//        return ConfigFactory.createConfigService("localhost"); // 原代码
    }
}