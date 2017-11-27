package com.jxlg.app.results;

import java.util.List;

public class Handler<T> {

	public Result<T> handler(T t) {
		Result<T> result = new Result<>();
		if (t != null &&!t.equals("")) {
			result.setMsg("请求成功");
			result.setState("1");
			result.setResponseOne(t);;
		}else{
			result.setMsg("请求失败");
			result.setState("0");
		}
		return result;
	}

	
	
	public Result<T> handlerList(List<T> t) {
		Result<T> result = new Result<>();
		if (t != null && t.size() > 0) {
			result.setMsg("请求成功");
			result.setState("1");
			result.setResponse(t);
		}else{
			result.setMsg("请求失败");
			result.setState("0");
		}
		return result;
	}
}
