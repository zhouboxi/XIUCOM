package com.jxlg.app.service;

import com.jxlg.app.entity.AdminInfo;
import com.jxlg.app.results.UtilPage;

public interface IAdminInfoService {
	//登录验证
	AdminInfo findByName(String adminCode);
	//查询所有人权限
	UtilPage<AdminInfo> findAll();
	
	AdminInfo findById(Integer id);
	
	//添加权限
	Boolean save(AdminInfo adminInfo);
	

}
