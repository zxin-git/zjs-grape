package com.zxin.java.spring.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zxin.java.spring.mybatis.plus.entity.User;

/**
 * 包含自定义方法的IService实现类
 * @author ZHANGXIN130
 */
public interface IUserService extends IService<User> {

    /**
     * 自定义的扩展方法
     * @param user
     */
    default void add(User user){

    }
}
