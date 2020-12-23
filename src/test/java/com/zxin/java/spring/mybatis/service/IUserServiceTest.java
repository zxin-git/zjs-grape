package com.zxin.java.spring.mybatis.service;

import com.zxin.java.spring.mybatis.plus.entity.User;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IUserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void saveBatch() {
        User user1 = new User(11L,"name11", 111, "email11");
        User user2 = new User(12L,"name12", 112, "email12");
        User user3 = new User(13L,"name13", 113, "email13");
        List<User> list = Lists.newArrayList(user1, user2, user3);
        userService.saveBatch(list);
    }

    @Test
    public void count() {
        int size = userService.count();
//        assertEquals(5, size);
    }


    /**
     * 未通过，原因未知
     */
    @Test
    public void list() {
        List<User> list = userService.list();
        list.stream().forEach(System.out::println);
    }

    @Test
    public void add() {
        assertEquals(0,0);
    }

}