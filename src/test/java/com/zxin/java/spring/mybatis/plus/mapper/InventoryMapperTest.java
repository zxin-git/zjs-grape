package com.zxin.java.spring.mybatis.plus.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxin.java.spring.mybatis.plus.entity.Inventory;
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
public class InventoryMapperTest {

    @Autowired
    private InventoryMapper mapper;

    @Test
    public void testInsert(){
        Inventory inventory = new Inventory();
        inventory.setCode("c1");
        inventory.setName("n1");
        inventory.setStock(10L);
        inventory.setExpend(2L);
        int result = mapper.insert(inventory);
        log.info("result:[{}], inventory:[{}]", result, inventory);
    }

    @Test
    public void testSelectList(){
        List<Inventory> list = mapper.selectList(null);
        list.stream().map(Inventory::toString).forEach(log::info);
    }

    @Test
    public void testUpdateById(){
        Inventory inventory = mapper.selectById(1L);
        inventory.setCode("c1");
        inventory.setName("n1");
        inventory.setStock(1L);
        inventory.setExpend(1L);
        mapper.updateById(inventory);
    }

    @Test
    public void testOptimisticLocker(){
        Inventory inventory = mapper.selectById(1L);
        Inventory inventory1 = new Inventory();
        inventory1.setId(inventory.getId());
        inventory1.setCode("c1");
        inventory1.setVersion(inventory.getVersion());
//        inventory.setName("n1");
//        inventory.setStock(10L);
//        inventory.setExpend(2L);
        // 3、执行更新操作
        mapper.updateById(inventory1);
    }

    @Test
    public void testOptimisticLocker2(){

        Inventory inventory2 = mapper.selectById(1L);
        inventory2.setCode("c2");
        inventory2.setName("n2");
        inventory2.setStock(2L);
        inventory2.setExpend(2L);

        Inventory inventory3 = mapper.selectById(1L);
        inventory3.setCode("c3");
        inventory3.setName("n3");
        inventory3.setStock(3L);
        inventory3.setExpend(3L);
        int update3 = mapper.updateById(inventory3);

        // 3、执行更新操作
        int update2 = mapper.updateById(inventory2);
        log.info("3:[{}], 2:[{}]", update3, update2);
    }

    @Test
    public void testLogicDelete(){
        mapper.deleteById(1);
    }

    @Test
    public void testLogicSelect(){
        List<Inventory> list = mapper.selectList(null);
        Inventory inventory = mapper.selectById(1L);
        log.info("list:[{}], inventory:[{}]", list, inventory);
    }

    @Test
    public void testLogicUpdate(){
        Inventory inventory = mapper.selectById(2L);
        inventory.setCode("c1");
        inventory.setName("n1");
        inventory.setStock(1L);
        inventory.setExpend(1L);
        int row = mapper.updateById(inventory);
        log.info("[{}]", row);
    }

    @Test
    public void testPage(){
        // 参数一：当前页
        // 参数二：页面大小
        Page<Inventory> page = new Page<>(2,5);
        mapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }
}
