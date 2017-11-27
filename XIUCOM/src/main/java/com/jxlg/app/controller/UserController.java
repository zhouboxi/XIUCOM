package com.jxlg.app.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxlg.app.entity.AdminInfo;
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
@RequestMapping(value = "/admin")
public class UserController {
	@Resource
	private IAdminInfoService iAdminInfoService;
	@Resource
	private IModuleInfoService iModuleInfoService;

	// 登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Result<AdminInfo> login(String name, String password) {
		Result<AdminInfo> result = null;
		Handler<AdminInfo> handler = new Handler<>();
		// 获取当前的subject.调用securityUtils.getSubject()
		Subject subject = SecurityUtils.getSubject();
		// 测试当前用户是否已经被认证,即是否已经登录 调用subject的isAuthenticated()
		if (!subject.isAuthenticated()) {
			// 若没用认证,则把用户名和密码封装为UsernamePasswordToken对象
			UsernamePasswordToken token = new UsernamePasswordToken(name, password);
			token.setRememberMe(true);
			try {
				subject.login(token);
			} catch (AuthenticationException e) {
				 System.out.println("登录失败"+e.getMessage());
				 return handler.handler(null);
			}
		}
		return handler.handler(new AdminInfo());
	}

	// 管理员添加
	// 注册
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Result<AdminInfo> register(@RequestBody AdminInfo adminInfo) {
		Boolean save = iAdminInfoService.save(adminInfo);
		Result<AdminInfo> result = new Result<>();
		if (save) {
			result.setMsg("请求成功!");
			result.setState("1");
		} else {
			result.setMsg("请求失败!");
			result.setState("0");
		}
		return result;
	}

	// 查询
	@RequestMapping(value = "/findAll")
	@ResponseBody
	public Result<UtilPage> findAll() {
		Handler<UtilPage> handler = new Handler<>();
		UtilPage<AdminInfo> utilPage = iAdminInfoService.findAll();
		Result<UtilPage> result = handler.handler(utilPage);
		return result;
	}

	// 查询
	@RequestMapping(value = "/findAll2")
	@ResponseBody
	public Result<UtilPage> findAll2() {
		Handler<UtilPage> handler = new Handler<>();
		UtilPage<ModuleInfo> utilPage = iModuleInfoService.findAll();
		Result<UtilPage> result = handler.handler(utilPage);
		return result;
	}

}
