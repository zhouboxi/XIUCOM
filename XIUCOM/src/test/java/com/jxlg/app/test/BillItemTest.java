package com.jxlg.app.test;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jxlg.app.entity.Bill;
import com.jxlg.app.entity.BillItem;
import com.jxlg.app.entity.Service;
import com.jxlg.app.results.UtilPage;
import com.jxlg.app.service.IBillItemService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-context.xml",
		"classpath:spring/spring-db.xml",
		"classpath:spring/spring-mvc.xml",
		"classpath:spring/spring-tx.xml"})
public class BillItemTest {
	
	@Resource
	private IBillItemService iBillService;
	
	@Test
	public void testSave(){
		BillItem item = new BillItem();
		Bill bill = new Bill();
		bill.setBillId(50);
		item.setBill(bill);
		Service service = new Service();
		service.setServiceId(53);
		item.setService(service);
		item.setCost(new BigDecimal(25.00));
		//iBillService.saveDetail(item);
	}
	@Test
	public void findAll(){
		 UtilPage<BillItem> search = iBillService.search(50);
		System.out.println(search);
	}
	
	

}
