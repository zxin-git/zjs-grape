package com.zxin.java.spring.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zxin
 */
@Data
public class Inventory {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String code;

    private String name;

    private Long stock;

    private Long expend;


    @Version
    @TableField(fill = FieldFill.UPDATE)
    private Long version;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer deleted;

}
