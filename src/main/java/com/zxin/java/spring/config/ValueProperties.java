package com.zxin.java.spring.config;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zxin
 */
public class ValueProperties {

    @Value("${xxx.strParam:abc}")
    private String strParam;

    @Value("#{${red.pack.activity.channel.codes:'21805,21806,21978'}.split(',')}")
    private Set<String> redPackActChannelCodes;

    @Value("#{${red.pack.prize.id.points.map:{9:900, 10:1500, 11:2000}}}")
    private Map<Integer, Integer> prizePointsMap;


    @Value("${test.list.ids:1,2,3}")
    private List<String> testList;

    @Value("${test.list.ids:1,2,3}")
    private String[] testArray;

    @Value("#{'${test.list}'.split(',')}")
    private List<String> list;



    @Value("#{${test.maps}}")
    private Map<String,String> maps;

}
