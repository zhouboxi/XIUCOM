package com.jxlg.app.service;

import java.util.List;

import com.jxlg.app.entity.RoleInfo;
import com.jxlg.app.results.UtilPage;

public interface IRoleInfoService {

	//添加权限
	Boolean save(RoleInfo roleInfo);
	//通过名字查询信息-->添加权限
	RoleInfo findByName(String name);
	
	//查询所有信息
	UtilPage<RoleInfo> findAll();
	
	//查询所有信息
	List<RoleInfo> findAllByadd();
	
	//对信息的删除
	UtilPage<RoleInfo> delete(Integer roleId);
	//对角色的修改
	RoleInfo findById(Integer roleId);
	
}
