package com.jxlg.app.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jxlg.app.entity.FunctionInfo;
import com.jxlg.app.entity.ModuleInfo;
import com.jxlg.app.service.IFunctionInfoService;
import com.jxlg.app.service.IModuleInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-context.xml",
		"classpath:spring/spring-db.xml",
		"classpath:spring/spring-mvc.xml",
		"classpath:spring/spring-tx.xml"})
public class ModuleInfoTest {
	
	@Resource
	private IFunctionInfoService iFunctionInfoService;
	
	@Test
	public void save(){
		FunctionInfo info = new FunctionInfo();
		//info.setFunctionCode("jsgl_index");
		info.setFunctionCode("gly_add");
		ModuleInfo moduleInfo = new ModuleInfo();
		moduleInfo.setModuleId(68);
		info.setModuleInfo(moduleInfo);
		info.setName("管理员管理添加");
		info.setUrl("/admin/admin_add.html");
		iFunctionInfoService.save(info);
	}
	
	

}
