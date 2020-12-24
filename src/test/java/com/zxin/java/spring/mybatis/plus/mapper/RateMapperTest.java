package com.zxin.java.spring.mybatis.plus.mapper;

import com.zxin.java.spring.mybatis.plus.entity.Rate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author zxin
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RateMapperTest {

    @Autowired
    private RateMapper mapper;

    @Test
    public void testInsert(){
        Rate rate = new Rate();
        rate.setCode("c1");
        rate.setName("n1");
        rate.setStock(10L);
        rate.setExpend(2L);
        int result = mapper.insert(rate);
        log.info("result:[{}], inventory:[{}]", result, rate);
    }

    @Test
    public void testSelectList(){
        List<Rate> list = mapper.selectList(null);
        list.stream().map(Rate::toString).forEach(log::info);
    }

    @Test
    public void testUpdateById(){
        Rate rate = mapper.selectById(1L);
        rate.setCode("c1");
        rate.setName("n1");
        rate.setStock(1L);
        rate.setExpend(1L);
        mapper.updateById(rate);
    }

    @Test
    public void testLogicDelete(){
        mapper.deleteById(2);
    }

}
