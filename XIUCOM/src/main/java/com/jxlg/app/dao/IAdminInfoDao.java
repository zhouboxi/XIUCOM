package com.jxlg.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jxlg.app.entity.AdminInfo;

public interface IAdminInfoDao extends JpaRepository<AdminInfo, Integer>,JpaSpecificationExecutor<AdminInfo>{
	
	AdminInfo findByAdminCode(String name);
	
	AdminInfo findByName(String name);
	
	
}
