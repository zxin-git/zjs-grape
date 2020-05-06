package com.zxin.java.spring.huazhu.reception.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.sun.org.apache.xerces.internal.util.Status;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zxin
 */
@Data
public class ResponseDTO {

    @JSONField(format = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime localDateTime = LocalDateTime.now();

    private Status status = Status.NOT_ALLOWED;
}
