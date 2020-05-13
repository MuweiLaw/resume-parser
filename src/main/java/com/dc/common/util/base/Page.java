package com.dc.common.util.base;

import java.util.List;

public class Page<T> {
	
	private Integer code;
	
	private String msg;
	
	private Integer count;
	
	private Integer page;
	
	private Integer limit;
	
	private List<T> data;
	
	public Page() {
		super();
	}

	public Page(Integer code, String msg, Integer count, List<T> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

	public Page(Integer code, String msg, Integer count, Integer page, Integer limit, List<T> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.page = page;
		this.limit = limit;
		this.data = data;
	}

	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public Integer getLimit() {
		return limit;
	}


	public void setLimit(Integer limit) {
		this.limit = limit;
	}


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
	
}
