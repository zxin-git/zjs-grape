package com.zxin.java.spring.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zxin
 */
@Data
@Component
public class ValueProperties {

    @Value("${test.value.name:abc}")
    private String name;

    @Value("${test.value.dateList2:2020-10-30,2020-11-20,2020-12-04}") //“，”间不能有空格
    private List<String> dateList2;

    @Value("${test.value.idList:1,2,3}")
    private List<String> idList;

    @Value("${test.value.ids:1,2,3}")
    private String[] ids;


    @Value("#{${test.value.codes:'21805,21806,21978'}.split(',')}")
    private Set<String> codes;

    @Value("#{'${test.value.dateList:2020-10-30,2020-11-20,2020-12-04}'.split(',')}") //“，”间不能有空格
    private List<String> dateList;


    @Value("#{${test.value.points.map:{9:900, 10:1500, 11:2000}}}")
    private Map<Integer, Integer> pointsMap;

}
