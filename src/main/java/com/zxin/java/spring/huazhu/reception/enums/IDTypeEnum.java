package com.zxin.java.spring.huazhu.reception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zxin
 */
@Getter
@AllArgsConstructor
public enum IDTypeEnum {

    C01("C01", "居民身份证"),
    C02("C02", "户口簿"),
    C03("C03", "军官证"),
    C04("C04", "警官证"),
    C05("C05", "士兵证"),
    C06("C06", "护照"),
    C54("C54", "旅行证"),
    C55("C55", "台湾居民来往大陆通行证"),
    C59("C59", "中华人民共和国出入境通行证"),
    C62("C62", "港澳居民来往内地通行证"),
    C65("C65", "驾驶证"),
    C66("C66", "台湾身份证"),
    C67("C67", "大陆往来台湾通行证"),

    ;

    private String code;

    private String message;

}
