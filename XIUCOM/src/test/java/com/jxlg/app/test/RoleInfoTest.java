package com.jxlg.app.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jxlg.app.entity.RoleInfo;
import com.jxlg.app.service.IRoleInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-context.xml",
		"classpath:spring/spring-db.xml",
		"classpath:spring/spring-mvc.xml",
		"classpath:spring/spring-tx.xml"})
public class RoleInfoTest {
	
	@Resource
	private IRoleInfoService iRoleInfoService;
	
	@Test
	public void save(){
		RoleInfo info = new RoleInfo();
		info.setName("报表");//账务账号 业务账号 角色管理 管理员管理 资费管理 账单管理 报表
		iRoleInfoService.save(info);
	}

}
