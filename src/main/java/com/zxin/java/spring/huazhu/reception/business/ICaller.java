package com.zxin.java.spring.huazhu.reception.business;

public interface ICaller<BO, RequestDTO, ResponseDTO> {

    default BO call(BO bo){
        RequestDTO requestDTO = toRequestDTO(bo);
        ResponseDTO responseDTO = callInner(requestDTO);
        BO BO = toResponseBO(bo);
        return assign(responseDTO, BO);
    }

    RequestDTO toRequestDTO(BO bo);

    ResponseDTO callInner(RequestDTO requestDTO);

    BO toResponseBO(BO bo);

    BO assign(ResponseDTO responseDTO, BO bo);
}
