package com.jxlg.app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxlg.app.entity.AdminInfo;
import com.jxlg.app.entity.Cost;
import com.jxlg.app.entity.ModuleInfo;
import com.jxlg.app.entity.RoleInfo;
import com.jxlg.app.results.Handler;
import com.jxlg.app.results.Result;
import com.jxlg.app.results.UtilPage;
import com.jxlg.app.service.IAdminInfoService;
import com.jxlg.app.service.IModuleInfoService;
import com.jxlg.app.service.IRoleInfoService;

@Controller
@SuppressWarnings("all")
@RequestMapping(value="/role")
public class RoleController {
	@Resource
	private IRoleInfoService roleInfoService;
	
	//注册
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Result<RoleInfo> register(@RequestBody RoleInfo roleInfo){
		Boolean save = roleInfoService.save(roleInfo);
		Result<RoleInfo> result = new Result<>();
		if(save){
			result.setMsg("请求成功!");
			result.setState("1");
		}else{
			result.setMsg("请求失败!");
			result.setState("0");
		}
		return result;
	}
		

	//查询
	@RequestMapping(value="/findAll")
	@ResponseBody
	public Result<UtilPage> findAll(){
		Handler<UtilPage> handler = new Handler<>();
		UtilPage<RoleInfo> utilPage = roleInfoService.findAll();
		Result<UtilPage> result = handler.handler(utilPage);
		return result;
	}
	//查询
	@RequestMapping(value="/findAllByadd")
	@ResponseBody
	public Result<RoleInfo> findAll2(){
		Handler<RoleInfo> handler = new Handler<>();
		List<RoleInfo> list = roleInfoService.findAllByadd();
		Result<RoleInfo> result = handler.handlerList(list);
		return result;
	}
	
	//对一项删除
	@RequestMapping("/delete")
	@ResponseBody
	public Result<UtilPage> delete(Integer roleId){
		UtilPage<RoleInfo> cost =roleInfoService.delete(roleId);
		Handler<UtilPage> handler = new Handler<>();
		Result<UtilPage> result = handler.handler(cost);
		return result;
	}
	
	@RequestMapping("/findOne")
	@ResponseBody
	public Result<RoleInfo> findOne(Integer roleId){
		RoleInfo findById = roleInfoService.findById(roleId);
		Handler<RoleInfo> handler = new Handler<>();
		Result<RoleInfo> result = handler.handler(findById);
		return result;
	}

}
