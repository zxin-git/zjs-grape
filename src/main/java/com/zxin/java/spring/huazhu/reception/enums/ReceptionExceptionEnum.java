package com.zxin.java.spring.huazhu.reception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zxin
 */
@Getter
@AllArgsConstructor
public enum ReceptionExceptionEnum {

    EMPTY_HOTEL_ID("30001", "酒店ID必传", null),
    UNSUPPORTED_ID_TYPE("30002", "不支持的证件类型", null),
    NOT_FOUND("30003","未找到接待单数据", null),
    ;

    private String code;

    private String message;

    private String responseDesc;

}
