package com.zxin.java.spring.mybatis.plus.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxin.java.spring.mybatis.plus.entity.User;
import com.zxin.java.spring.mybatis.plus.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * 自动扫描并注入Mapper
 * @author ZHANGXIN130
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.zxin.java.spring.mybatis.plus.mapper")
public class MybatisConfig {


    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    /**
     * for 物理分页
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    /**
     * 构建默认IService实现类
     * 只能用{@link IService}接收
     *
     * @return
     */
//    @Bean
    @Deprecated
    public IService<User> UserService(){
        return new ServiceImpl<UserMapper, User>();
    }
}
