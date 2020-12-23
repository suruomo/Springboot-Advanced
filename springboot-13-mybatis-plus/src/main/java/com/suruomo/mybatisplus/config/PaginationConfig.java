package com.suruomo.mybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: suruomo
 * @date: 2020/12/23 14:53
 * @description: MyBatis Plus分页插件配置类
 */
@Configuration
public class PaginationConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor ();
    }
}
