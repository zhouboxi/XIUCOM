package com.jxlg.app.test;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jxlg.app.entity.Account;
import com.jxlg.app.entity.Bill;
import com.jxlg.app.results.UtilPage;
import com.jxlg.app.service.IBillService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-context.xml",
		"classpath:spring/spring-db.xml",
		"classpath:spring/spring-mvc.xml",
		"classpath:spring/spring-tx.xml"})
public class BillTest {
	
	@Resource
	private IBillService iBillService;
	
	@Test
	public void testSave(){
		Bill bill = new Bill();
		Account account = new Account();
		account.setAccountId(21);
		bill.setAccount(account);
		bill.setBillMonth("2017年11月");
		bill.setCost(new BigDecimal(50.08));
		iBillService.save(bill);
	}
	@Test
	public void findAll(){
		UtilPage<Bill> findAll = iBillService.findAll(0);
		List<Bill> all = findAll.getAll();
		System.out.println(all);
	}
	
	

}
