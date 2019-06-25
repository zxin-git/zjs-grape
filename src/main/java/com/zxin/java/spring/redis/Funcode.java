package com.zxin.java.spring.redis;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 产品包表
 * 对应DSP.DS_PRODUCT_SUITES表
 * 
 * @author zxin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcode implements Serializable{

	private static final long serialVersionUID = 3645183776483924519L;

	private Integer id;
	
	private String code;
	
	private String name;
	
	private Integer type;
	
	private Integer status;//产品状态
	
	private String version;
	
	
//	private BigDecimal price;
//	
//	private int updater; //更新人
//	
//	private long modTime;//修改时间
//	
//	private long createTime;//创建时间
	
	
	
	
	

}
