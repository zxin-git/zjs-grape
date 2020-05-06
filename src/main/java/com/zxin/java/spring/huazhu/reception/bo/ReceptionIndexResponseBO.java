package com.zxin.java.spring.huazhu.reception.bo;

import com.zxin.java.spring.huazhu.reception.enums.IDTypeEnum;
import com.zxin.java.spring.huazhu.reception.enums.OrderStatusEnum;
import lombok.Data;

/**
 * @author zxin
 */
@Data
public class ReceptionIndexResponseBO {

    private String hotelId;

    private String roomNo;

    private OrderStatusEnum orderStatus;

    private IDTypeEnum iDType;

    private String iDNo;

    private String crsOrderNo;

    private String pmsOrderNo;

}
