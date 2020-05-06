package com.zxin.java.spring.huazhu.reception.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author zxin
 */
@Data
@ApiModel(description = "匹配单个接待单信息查询类")
public class ReceptionIndexRequestDTO {

    @NotEmpty
    @ApiModelProperty(value = "酒店ID", example = "2000014", position = 1, required = true)
    private String hotelId;

    @ApiModelProperty(value = "房间号", example = "1403", position = 2)
    private String roomNo;

    @ApiModelProperty(name = "iDType", value = "证件类型", example = "C01", position = 3)
    private String iDType;

    @ApiModelProperty(name = "iDNo", value = "证件号", example = "110103198902154632", position = 4)
    private String iDNo;

}
