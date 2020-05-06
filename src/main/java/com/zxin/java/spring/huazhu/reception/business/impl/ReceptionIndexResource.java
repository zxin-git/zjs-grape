package com.zxin.java.spring.huazhu.reception.business.impl;

import com.zxin.java.spring.huazhu.reception.bo.ReceptionIndexBO;
import com.zxin.java.spring.huazhu.reception.business.IBusinessCaller;
import com.zxin.java.spring.huazhu.reception.business.IResource;
import com.zxin.java.spring.huazhu.reception.dto.ReceptionIndexRequestDTO;
import com.zxin.java.spring.huazhu.reception.dto.ReceptionIndexResponseDTO;
import org.springframework.stereotype.Service;

/**
 * @author zxin
 */
@Service
public class ReceptionIndexResource implements IResource<ReceptionIndexRequestDTO, ReceptionIndexBO, ReceptionIndexBO, ReceptionIndexResponseDTO> {

    private IBusinessCaller business;

    @Override
    public ReceptionIndexBO wrap2RequestBO(ReceptionIndexRequestDTO requestDTO) {
        ReceptionIndexBO bo = new ReceptionIndexBO();
        bo.setHotelId(requestDTO.getHotelId());
        return null;
    }

    @Override
    public ReceptionIndexBO assign(ReceptionIndexRequestDTO receptionIndexRequestDTO, ReceptionIndexBO receptionIndexBO) {
        return null;
    }

    @Override
    public ReceptionIndexBO business(ReceptionIndexBO receptionIndexBO) {
        return null;
    }

    @Override
    public ReceptionIndexResponseDTO toResponseDTO(ReceptionIndexBO receptionIndexBO) {
        return null;
    }
}
