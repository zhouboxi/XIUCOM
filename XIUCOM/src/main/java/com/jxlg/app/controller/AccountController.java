package com.jxlg.app.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxlg.app.entity.Account;
import com.jxlg.app.entity.Cost;
import com.jxlg.app.results.Handler;
import com.jxlg.app.results.Result;
import com.jxlg.app.results.UtilPage;
import com.jxlg.app.service.IAccountService;
import com.sun.tools.internal.ws.processor.model.Request;

@Controller
@SuppressWarnings("all")
@RequestMapping("/account")
public class AccountController {
	
	@Resource
	private IAccountService iAccountService;
	//对管理员进行添加
	@RequestMapping("/add")
	@ResponseBody
	public Result<Account> saveAccount(@RequestBody Account account){
		Account account2=null;
		if(account.getLoginName()!=null&&!account.getLoginName().equals("")){
			account2= iAccountService.save(account);
		}
		Handler<Account> handler = new Handler<>();
		Result<Account> result = handler.handler(account2);
		return result;
	}
	
	//对所有的的信息查询
	@RequestMapping("/all")
	@ResponseBody
	public  Result<UtilPage> findAll(@RequestParam Integer pageNum){
		UtilPage<Account> page = iAccountService.findAll(pageNum);
		Handler<UtilPage> handler = new Handler<>();
		Result<UtilPage> result = handler.handler(page);
		return result;
	}
	
	//对用户信息查询
	@RequestMapping("/findOne")
	@ResponseBody
	public Result<Account> findOne(@RequestParam Integer accountid){
		Account account = iAccountService.findById(accountid);
		Handler<Account> handler = new Handler<>();
		Result<Account> result = handler.handler(account);
		return result;
	}
	
	//删除
	@RequestMapping("/delete")
	@ResponseBody
	public Result<UtilPage> delete(@RequestParam String accountid){
		UtilPage<Account> delete = iAccountService.delete(Integer.parseInt(accountid));
		Handler<UtilPage> handler = new Handler<>();
		Result<UtilPage> result = handler.handler(delete);
		return result;
		
	}
	
	//开通暂停
	@RequestMapping("/open")
	@ResponseBody
	public Result<UtilPage> open(@RequestParam Integer accountid,@RequestParam  String state){
		UtilPage<Account> update = iAccountService.update(accountid, state);
		Handler<UtilPage> handler = new Handler<>();
		Result<UtilPage> result = handler.handler(update);
		return result;
	}
	
	//模糊查询
	@RequestMapping("/search")
	@ResponseBody
	public Result<UtilPage> search(@RequestParam String idcardNo, @RequestParam String realName,
			@RequestParam String loginName,@RequestParam String status){
		
		UtilPage<Account> search = iAccountService.search(idcardNo, realName, loginName, status);
		Handler<UtilPage> handler = new Handler<>();
		Result<UtilPage> result = handler.handler(search);
		return result;
		
	}
	
	//更新信息
	@RequestMapping("/update")
	@ResponseBody
	public Result<Account> update(@RequestBody Account account){
		Boolean updateOne = iAccountService.updateOne(account);
		Result<Account> result = new Result<>();
		if(updateOne){
			result.setState("1");
			result.setMsg("请求成功!");
		}else{
			result.setState("0");
			result.setMsg("请求失败!");
		}
		return result;
		
	}
	@RequestMapping(value="/findByIdcard")
	@ResponseBody 
	public Result<Account> getAccountName(@RequestParam(value="idcardNo",required=true) String idcardNo){
		Account account = iAccountService.findByIdCard(idcardNo);
		Account account2 = new Account();
		account2.setLoginName(account.getLoginName());
		account2.setAccountId(account.getAccountId());
		Handler<Account> handler = new Handler<>();
		Result<Account> result = handler.handler(account2);
		return result;
	}
	

}
