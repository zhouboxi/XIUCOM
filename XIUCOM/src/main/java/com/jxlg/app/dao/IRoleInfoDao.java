package com.jxlg.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jxlg.app.entity.RoleInfo;

public interface IRoleInfoDao extends JpaRepository<RoleInfo, Integer>{

	RoleInfo findByName(String name);
	
	@Query(value="select ROLE_ID,NAME from role_info",nativeQuery=true)
	List<RoleInfo> findAllBySql();
}
