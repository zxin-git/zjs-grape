package com.zxin.java.spring.huazhu.reception.business;

/**
 * 默认值赋值服务
 */
public interface IResource<RequestDTO, RequestBO, ResponseBO, ResponseDTO> {

    /**
     * 资源入口
     * @param requestDTO
     * @return
     */
    default ResponseDTO resource(RequestDTO requestDTO){
        RequestBO requestBO = toRequestBO(requestDTO);

        ResponseBO responseBO = business(requestBO);

        ResponseDTO responseDTO = toResponseDTO(responseBO);
        return responseDTO;
    }

    /**
     * 转换成业务类
     * @param requestDTO
     * @return
     */
    default RequestBO toRequestBO(RequestDTO requestDTO){
        validate(requestDTO);
        RequestBO requestBO = wrap2RequestBO(requestDTO);
        requestBO = assign(requestDTO, requestBO);
        return requestBO;
    }

    /**
     * 校验DTO参数是否符合业务
     * @param requestDTO
     */
    default void validate(RequestDTO requestDTO){

    };

    /**
     * 类型转换包装，不涉及任务业务判断
     * @param requestDTO
     * @return
     */
    RequestBO wrap2RequestBO(RequestDTO requestDTO);

    /**
     * 根据填充BO默认值
     * @param requestDTO
     * @param requestBO
     * @return
     */
    RequestBO assign(RequestDTO requestDTO, RequestBO requestBO);

    /**
     * 业务逻辑
     * @param requestBO
     * @return
     */
    ResponseBO business(RequestBO requestBO);

    /**
     * 转换响应类
     * @param responseBO
     * @return
     */
    ResponseDTO toResponseDTO(ResponseBO responseBO);
}
