package com.zxin.java.spring.huazhu.reception.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zxin
 */
@Data
public class ReceptionIndexResponseDTO {

    @ApiModelProperty(value = "酒店Id", example = "2000014", position = 1)
    private String hotelId;

    @ApiModelProperty(value = "房间号", example = "1403", position = 2)
    private String roomNo;

    @ApiModelProperty(value = "订单状态: [1001:入住中]", example = "1001", position = 4)
    private String orderStatus;

    @ApiModelProperty(value = "crs订单号", example = "101", position = 5)
    private String crsOrderNo;

    @ApiModelProperty(value = "pms订单号", example = "101", position = 6)
    private String pmsOrderNo;

}
