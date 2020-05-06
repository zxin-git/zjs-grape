package com.zxin.java.spring.huazhu.reception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zxin
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum {

    I("I", "入住"),
    O("O", "退房"),
    S("S", "挂账"),
    OTHER("OTHER", "其他"),
    ;

    private String code;

    private String message;

}
