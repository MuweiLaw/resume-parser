package com.dc.common.util.base;

import com.dc.annotation.ParamMeta;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnResult<T>{

	@ParamMeta(value="返回编码 0:成功 1:失败")
	private Integer code;
	
	@ParamMeta(value="返回信息")
	private String msg;
	
	@ParamMeta(value="返回数据")
	private T data;
	

	public ReturnResult() {
		super();
	}


	/**
	 * 不返回null，默认为成功
	 * @param code
	 * @param msg
	 * @param data
	 */
	public ReturnResult(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public static <T> ReturnResult<T> getSuccessResult(T data){
		return new ReturnResult<T>(0, "操作成功", data);
	}

	public static <T> ReturnResult<T> getErrorResult(T data){
		return new ReturnResult<T>(1, "操作失败", data);
	}
	
	public static <T> ReturnResult<T> getErrorResult(String msg){
		return new ReturnResult<T>(1, msg, null);
	}

	public Integer getCode() {
		return code==null?0:1;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg==null?"":msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}

}
