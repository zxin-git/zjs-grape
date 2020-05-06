package com.zxin.java.spring.huazhu.reception.business;

public interface IBusinessHandler<RequestBO, ResponseBO, RequestDTO, ResponseDTO> {

    default ResponseBO handle(RequestBO requestBO){
        RequestDTO requestDTO = wrap2RequestDTO(requestBO);
        ResponseDTO responseDTO = call(requestDTO);
        ResponseBO responseBO = wrap2ResponseBO(requestBO);
        return assign(responseDTO, responseBO);
    }

    RequestDTO wrap2RequestDTO(RequestBO requestBO);

    ResponseDTO call(RequestDTO requestDTO);

    ResponseBO wrap2ResponseBO(RequestBO requestBO);

    ResponseBO assign(ResponseDTO responseDTO, ResponseBO responseBO);

}