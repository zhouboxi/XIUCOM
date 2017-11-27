package com.jxlg.app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxlg.app.entity.Cost;
import com.jxlg.app.results.Handler;
import com.jxlg.app.results.Result;
import com.jxlg.app.results.UtilPage;
import com.jxlg.app.service.ICostService;

@Controller
@SuppressWarnings("all")
@RequestMapping("/cost")
public class CostController {
	@Resource(name="costService")
	private ICostService iCostService;
	
	//查询所有
	@RequestMapping("/findall")
	@ResponseBody
	public Result<UtilPage> getAllCost(@RequestParam Integer pageNum){
		UtilPage<Cost> allCost = iCostService.allCost(pageNum);
		Handler<UtilPage> handler = new Handler<>();
		Result<UtilPage> result = handler.handler(allCost);
		return result;
	}
	
	//对业务开启
	@RequestMapping("/open")
	@ResponseBody
	public Result<UtilPage> updateCost(@RequestParam String constid){
		UtilPage<Cost> cost = iCostService.updateCost(Integer.parseInt(constid));
		Handler<UtilPage> handler = new Handler<>();
		Result<UtilPage> result = handler.handler(cost);
		return result;
	}
	
	//对一项删除
	@RequestMapping("/delete")
	@ResponseBody
	public Result<UtilPage> deleteCost(@RequestParam String constid){
		UtilPage<Cost> cost =iCostService.deleteCost(Integer.parseInt(constid));
		Handler<UtilPage> handler = new Handler<>();
		Result<UtilPage> result = handler.handler(cost);
		return result;
	}
	
	//更新参数类
	@RequestMapping(value="/updateOne",
			method=RequestMethod.POST, 
		    consumes="application/json")
	@ResponseBody
	public Result<Cost> updateOne(@RequestBody Cost cost){
		Boolean booleans = iCostService.updateOne(cost);
		Result<Cost> result = new Result<>();
		if(booleans){
			result.setState("1");
			result.setMsg("请求成功!");
		}else{
			result.setState("0");
			result.setMsg("请求失败!");
		}
		return result;
	}
	
		//保存参数类
		@RequestMapping(value="/saveOne",
				method=RequestMethod.POST, 
			    consumes="application/json")
		@ResponseBody
		public Result<Cost> saveOne(@RequestBody Cost cost){
			Cost cost2=null;
			if(cost.getName()!=null&&!cost.getName().equals("")){
				cost2= iCostService.saveCost(cost);
			}
			Handler<Cost> handler = new Handler<>();
			Result<Cost> result = handler.handler(cost2);
			return result;
		}
	
	
	//通过id查找
	@RequestMapping("/findOne")
	@ResponseBody
	public Result<Cost> findOneCost(@RequestParam String constid){
		Cost cost = iCostService.findById(Integer.parseInt(constid));
		Handler<Cost> handler = new Handler<>();
		Result<Cost> result = handler.handler(cost);
		return result;
	}
	
	
	

}
