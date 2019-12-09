package com.zxin.java.spring.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxin.java.spring.mybatis.bean.User;
import com.zxin.java.spring.mybatis.mapper.UserMapper;
import com.zxin.java.spring.mybatis.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * 注入IUserServices实现类
 * @athor ZHANGXIN130
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
