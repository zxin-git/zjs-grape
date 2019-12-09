package com.zxin.java.spring.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxin.java.spring.mybatis.bean.Person;
import com.zxin.java.spring.mybatis.mapper.PersonMapper;
import org.springframework.stereotype.Service;

/**
 * 只能用PersonBaseServiceImpl接收，用{@link IService}存在冲突
 *
 * @author ZHANGXIN130
 */
@Deprecated
public class PersonBaseServiceImpl extends ServiceImpl<PersonMapper, Person> {

}
