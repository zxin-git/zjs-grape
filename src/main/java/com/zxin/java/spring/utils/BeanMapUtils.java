package com.zxin.java.spring.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. MapList组合  转换成 对象嵌套
 * @author zxin
 */
public class BeanMapUtils {

    public static void main(String[] args) {
        List<Bean> beans = new ArrayList<>();
        Bean b1 = Bean.builder().id(1).name("b1").build();
        Bean b2 = Bean.builder().id(2).name("b2").build();
        beans.add(b1);
        beans.add(b2);
        String s = JSON.toJSONString(beans);
        List aa = JSONObject.parseArray(s);
        System.out.println(aa);
    }


    @Data
    @Builder
    public static class Bean{
        private String name;
        private Integer id;
        private Bean bean;
        private List<SubBean> subBeans;
    }

    @Data
    public static class SubBean{
        private String name;
        private Long id;
    }
}
