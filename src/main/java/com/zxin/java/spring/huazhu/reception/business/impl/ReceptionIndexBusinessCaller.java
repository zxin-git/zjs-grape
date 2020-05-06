package com.zxin.java.spring.huazhu.reception.business.impl;

import com.zxin.java.spring.huazhu.reception.bo.ReceptionIndexRequestBO;
import com.zxin.java.spring.huazhu.reception.bo.ReceptionIndexResponseBO;
import com.zxin.java.spring.huazhu.reception.business.IBusinessCaller;
import com.zxin.java.spring.huazhu.reception.cdto.ReceptionIndexInputDTO;
import com.zxin.java.spring.huazhu.reception.cdto.ReceptionIndexOutputDTO;
import org.springframework.stereotype.Service;

/**
 * @author zxin
 */
@Service
public class ReceptionIndexBusinessCaller implements IBusinessCaller<ReceptionIndexRequestBO, ReceptionIndexInputDTO, ReceptionIndexOutputDTO,ReceptionIndexResponseBO> {

    @Override
    public ReceptionIndexInputDTO wrap2RequestDTO(ReceptionIndexRequestBO receptionIndexRequestBO) {
        return null;
    }

    @Override
    public ReceptionIndexOutputDTO call(ReceptionIndexInputDTO receptionIndexInputDTO) {
        return null;
    }

    @Override
    public ReceptionIndexResponseBO wrap2ResponseBO(ReceptionIndexRequestBO receptionIndexRequestBO) {
        return null;
    }

    @Override
    public ReceptionIndexResponseBO assign(ReceptionIndexOutputDTO receptionIndexOutputDTO, ReceptionIndexResponseBO receptionIndexResponseBO) {
        return null;
    }
}
