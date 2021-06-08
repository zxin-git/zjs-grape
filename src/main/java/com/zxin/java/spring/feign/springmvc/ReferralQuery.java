package com.zxin.java.spring.feign.springmvc;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author zxin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReferralQuery {

    @ApiModelProperty("新生用户ID")
    private Long userId;

    @ApiModelProperty("介绍人用户ID")
    private Long referrerUserId;

    @ApiModelProperty("转介绍活动ID")
    private Long activityId;

    @ApiModelProperty(value = "渠道code")
    private String code;
    @ApiModelProperty(value = "渠道key")
    private String key;
    @ApiModelProperty(value = "uke source id")
    private String ukeSource;
    @ApiModelProperty(value = "转介绍绑定销售userId")
    protected Long promoterUserId;

    @ApiModelProperty(value = "来源方式，0-注册预约，4-补录")
    private Integer sourceCode;
    @ApiModelProperty(value = "转介绍类型，CR,CC等")
    private String referralType;
    @ApiModelProperty(value = "来源定位，名单统计用")
    private String location;

    @ApiModelProperty(value = "根据转介绍时间查询时的起始时间，包含")
    private LocalDateTime referralTimeStart;
    @ApiModelProperty(value = "根据转介绍时间查询时的截止时间，不包含")
    private LocalDateTime referralTimeEnd;

}
