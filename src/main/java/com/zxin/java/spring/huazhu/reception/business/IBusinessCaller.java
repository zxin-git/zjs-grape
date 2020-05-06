package com.zxin.java.spring.huazhu.reception.business;

/**
 * @author zxin
 */
public interface IBusinessCaller<RequestBO, RequestDTO, ResponseDTO, ResponseBO> {

    default ResponseBO business(RequestBO requestBO){
        RequestDTO requestDTO = toRequestDTO(requestBO);

        ResponseDTO responseDTO = call(requestDTO);

        ResponseBO responseBO = toResponseBO(requestBO, responseDTO);
        return responseBO;
    }

    default RequestDTO toRequestDTO(RequestBO requestBO){
        return wrap2RequestDTO(requestBO);
    }

    /**
     * 参数转换，不涉及业务逻辑
     * @param requestBO
     * @return
     */
    RequestDTO wrap2RequestDTO(RequestBO requestBO);

    /**
     * 远程接口调用
     * @param requestDTO
     * @return
     */
    ResponseDTO call(RequestDTO requestDTO);

    default ResponseBO toResponseBO(RequestBO requestBO, ResponseDTO responseDTO){
        ResponseBO responseBO = wrap2ResponseBO(requestBO);
        return assign(responseDTO, responseBO);
    }

    /**
     * 参数转换，不涉及业务逻辑
     * @param requestBO
     * @return
     */
    ResponseBO wrap2ResponseBO(RequestBO requestBO);

    /**
     * 赋值
     * @param responseDTO
     * @param responseBO
     * @return
     */
    ResponseBO assign(ResponseDTO responseDTO, ResponseBO responseBO);

}
