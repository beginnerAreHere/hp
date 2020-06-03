package com.example.common.constant;

/**
 * 响应CODE和message 枚举
 * 
 * @Date 2020年5月9日
 * @author hxl
 *
 */
public enum ResposeEnum {
	ResposeSuccess(0, "success"),
	DateParseException(1, "日期转化错误"),
	ParamNullException(2,"参数为空"),
	CommonError(3,""); 
	//key
	private int code;
	//value
	private String message;

	private ResposeEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

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

}
