package com.jxlg.app.test;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jxlg.app.entity.AdminInfo;
import com.jxlg.app.entity.RoleInfo;
import com.jxlg.app.service.IAdminInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-context.xml",
		"classpath:spring/spring-db.xml",
		"classpath:spring/spring-mvc.xml",
		"classpath:spring/spring-tx.xml"})
public class AdminInfoTest {
	
	@Resource
	private IAdminInfoService iAdminInfoService;
	
	@Test
	public void save(){
		AdminInfo adminInfo = new AdminInfo();
		adminInfo.setAdminCode("繁花似锦");
		adminInfo.setEmail("hhsj@12306.com");
		adminInfo.setName("海绵");
		adminInfo.setPassword("1234567");
		adminInfo.setTelephone("123456");
		HashSet<RoleInfo> set = new HashSet<>();
		RoleInfo roleInfo1 = new RoleInfo();
		RoleInfo roleInfo2 = new RoleInfo();
		RoleInfo roleInfo3 = new RoleInfo();
		RoleInfo roleInfo4 = new RoleInfo();
		RoleInfo roleInfo5 = new RoleInfo();
		RoleInfo roleInfo6 = new RoleInfo();
		RoleInfo roleInfo7 = new RoleInfo();
		roleInfo1.setRoleId(59);
		roleInfo2.setRoleId(60);
		roleInfo3.setRoleId(61);
		roleInfo4.setRoleId(62);
		roleInfo5.setRoleId(63);
		roleInfo6.setRoleId(64);
		roleInfo7.setRoleId(65);
		set.add(roleInfo1);
		set.add(roleInfo2);
		set.add(roleInfo3);
		set.add(roleInfo4);
		set.add(roleInfo5);
		set.add(roleInfo6);
		set.add(roleInfo7);
		adminInfo.setRoleInfos(set);
		//iAdminInfoService.save(adminInfo);
	}
	@Test
	public void findById(){
		AdminInfo findById = iAdminInfoService.findById(66);
		Set<RoleInfo> set = findById.getRoleInfos();
		for (RoleInfo roleInfo : set) {
			System.out.println(roleInfo.getName());
		}
	}
	

}
