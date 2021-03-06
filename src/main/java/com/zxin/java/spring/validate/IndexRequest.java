package com.zxin.java.spring.validate;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zxin
 */
@Data
public class IndexRequest {

//    @NotNull(groups = {Save.class, Update.class})
    private Integer id;

}
