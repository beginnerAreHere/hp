package com.example.entity.common;

import com.example.common.constant.ResposeEnum;

/**
 * 公用反馈体
 * @Date 2020年5月8日
 * @author hxl
 *
 */
public class CommonResposeEntity {
	//响应编码
	private int code;
	//响应信息
	private String message;
	//响应对象
	private Object data;
	//初始化
	public CommonResposeEntity() {
		this.code=ResposeEnum.ResposeSuccess.getCode();
		this.message=ResposeEnum.ResposeSuccess.getMessage();
		this.data="";
	}
	public CommonResposeEntity(int code,String message) {
		this.code=ResposeEnum.ResposeSuccess.getCode();
		this.message=ResposeEnum.ResposeSuccess.getMessage();
		this.data="";
	}
	public CommonResposeEntity(ResposeEnum resposeEnum) {
		this.code=resposeEnum.getCode();
		this.message=resposeEnum.getMessage();
		this.data="";
	}
	/**
	 * 通过响应枚举设置反馈
	 * @param resposeEnum 响应枚举
	 */
	public void SetCodeMessage(ResposeEnum resposeEnum) {
		this.code=resposeEnum.getCode();
		this.message=resposeEnum.getMessage();
		this.data="";
	};
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return " {\"" + code + "\":'" + code + "', " + message + "\":'" + message + "', " + data + "\":'" + data + "}";
	}
    
}
