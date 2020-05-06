package com.zxin.java.spring.huazhu.reception.bo;

import com.zxin.java.spring.huazhu.reception.enums.IDTypeEnum;
import lombok.Data;

/**
 * @author zxin
 */
@Data
public class ReceptionIndexRequestBO {

    private String hotelId;

    private String roomNo;

    private IDTypeEnum iDType;

    private String iDNo;

}
