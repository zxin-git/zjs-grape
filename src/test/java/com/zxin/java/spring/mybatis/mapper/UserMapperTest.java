package com.zxin.java.spring.mybatis.mapper;

import com.zxin.java.spring.mybatis.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void selectList(){
        List<User> list =  userMapper.selectList(null);
        System.out.println(list.size());
        assertEquals(5, list.size());
    }


}