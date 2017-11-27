package com.jxlg.app.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jxlg.app.entity.ModuleInfo;
import com.jxlg.app.service.IModuleInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-context.xml",
		"classpath:spring/spring-db.xml",
		"classpath:spring/spring-mvc.xml",
		"classpath:spring/spring-tx.xml"})
public class FunctionInfoTest {
	
	@Resource
	private IModuleInfoService iModuleInfoService;
	
	@Test
	public void save(){
		ModuleInfo moduleInfo = new ModuleInfo();
//		moduleInfo.setName("角色管理");
//		moduleInfo.setName("管理员管理");
//		moduleInfo.setName("资费管理");
//		moduleInfo.setName("账务账号");
//		moduleInfo.setName("业务账号");
//		moduleInfo.setName("账单");
		moduleInfo.setName("报表");
		iModuleInfoService.save(moduleInfo);
	}
	
	

}
