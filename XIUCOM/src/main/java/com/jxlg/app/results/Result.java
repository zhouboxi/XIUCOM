package com.jxlg.app.results;

import java.util.List;

public class Result<T> {
	private String msg;
	private String state;
	private List<T> response;
	private T responseOne;
	public Result() {
		
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<T> getResponse() {
		return response;
	}
	public void setResponse(List<T> response) {
		this.response = response;
	}
	public T getResponseOne() {
		return responseOne;
	}
	public void setResponseOne(T responseOne) {
		this.responseOne = responseOne;
	}
	
	 

}
