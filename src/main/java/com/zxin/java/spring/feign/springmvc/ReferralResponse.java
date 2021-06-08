package com.zxin.java.spring.feign.springmvc;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zxin
 */
@Data
public class ReferralResponse {

    @ApiModelProperty("新生用户ID")
    private Long userId;

    @ApiModelProperty("介绍人用户ID")
    private Long referrerUserId;

    @ApiModelProperty("转介绍活动ID")
    private Long activityId;

    @ApiModelProperty(value = "转介绍绑定销售userId")
    protected Long promoterUserId;

    /**
     * 名单分配相关
     */
    @ApiModelProperty(value = "渠道code")
    private String code;
    @ApiModelProperty(value = "渠道key")
    private String key;
    @ApiModelProperty(value = "uke source id")
    private String ukeSource;


    @ApiModelProperty("转介绍绑定时间")
    private LocalDateTime referralTime;


    @ApiModelProperty("转介绍关系来源方式：0：注册添加，1:销售后台新增, 2:藏经阁转介绍, 3:手动添加,4.补录, 5解绑, 6变更")
    private Integer sourceCode;
    @ApiModelProperty(value = "转介绍类型，CR,CC等")
    private String referralType;
    @ApiModelProperty(value = "来源定位，名单统计用")
    private String location;

}
