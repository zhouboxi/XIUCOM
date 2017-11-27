package com.jxlg.app.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxlg.app.entity.Account;
import com.jxlg.app.entity.Service;
import com.jxlg.app.results.Handler;
import com.jxlg.app.results.Result;
import com.jxlg.app.results.UtilPage;
import com.jxlg.app.service.ISerService;

@Controller
@SuppressWarnings("all")
@RequestMapping(value="/service")
public class ServiceController {
	
	@Resource 
	private ISerService iSerService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Result<Service> save(@RequestBody Service service){
		Service save = iSerService.save(service);
		Handler<Service> handler = new Handler<>();
		Result<Service> result = handler.handler(save);
		return result;
		
	}
	@RequestMapping(value="/findAll")
	@ResponseBody
	public Result<UtilPage> findAll(@RequestParam Integer pageNum){
		UtilPage<Service> findAll = iSerService.findAll(pageNum);
		Handler<UtilPage> handler = new Handler<>();
		Result<UtilPage> result = handler.handler(findAll);
		return result;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Result<UtilPage> delete(@RequestParam Integer serviceId){
		UtilPage<Service> delete = iSerService.delete(serviceId);
		Handler<UtilPage> handler = new Handler<>();
		Result<UtilPage> result = handler.handler(delete);
		return result;
		
	}
	
	@RequestMapping(value="/open",method=RequestMethod.POST)
	@ResponseBody
	public Result<UtilPage> open(@RequestParam Integer serviceId,@RequestParam  String state){
		UtilPage<Service> update = iSerService.update(serviceId, state);
		Handler<UtilPage> handler = new Handler<>();
		Result<UtilPage> result = handler.handler(update);
		return result;
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@ResponseBody
	public Result<UtilPage> search(@RequestParam String osUsername, @RequestParam  String unixHost, 
			@RequestParam String idcardNo, @RequestParam  String status){
		UtilPage<Service> search = iSerService.search(osUsername, unixHost, idcardNo, status);
		Handler<UtilPage> handler = new Handler<>();
		Result<UtilPage> result = handler.handler(search);
		return result;
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public Result<Service> update(@RequestBody Service service){
		Boolean updateOne = iSerService.updateOne(service);
		Result<Service> result = new Result<>();
		if(updateOne){
			result.setState("1");
			result.setMsg("请求成功!");
		}else{
			result.setState("0");
			result.setMsg("请求失败!");
		}
		return result;
		
	}
	
	@RequestMapping(value="/findOne")
	@ResponseBody
	public Result<Service> findOne(@RequestParam Integer serviceid){
		Service service = iSerService.findById(serviceid);
		Handler<Service> handler = new Handler<>();
		Result<Service> result = handler.handler(service);
		return result;
	}
	@RequestMapping(value="/updateOne",method=RequestMethod.POST)
	@ResponseBody
	public Result<Service> updateOne(@RequestBody Service service){
		Boolean updateOne= iSerService.updateOne(service);
		Result<Service> result = new Result<>();
		if(updateOne){
			result.setState("1");
			result.setMsg("请求成功!");
		}else{
			result.setState("0");
			result.setMsg("请求失败!");
		}
		return result;
	}

}
