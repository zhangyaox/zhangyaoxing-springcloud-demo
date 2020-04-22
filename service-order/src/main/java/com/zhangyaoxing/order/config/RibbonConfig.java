package com.zhangyaoxing.order.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfig {
    /**
     * restTemplate发送请求
     * LoadBalanced 注解可以负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){//RestTemplate用bean注入 之后可以调用
        return new RestTemplate();
    }

    /**
     * 指定负载均衡算法
     * @return
     */
    @Bean
    public IRule iRule(){
        return new RoundRobinRule();
    }
}
