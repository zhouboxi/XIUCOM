package com.jxlg.app.test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jxlg.app.dao.IAccountDao;
import com.jxlg.app.dao.ICostDao;
import com.jxlg.app.entity.Account;
import com.jxlg.app.entity.Cost;
import com.jxlg.app.entity.Service;
import com.jxlg.app.results.UtilPage;
import com.jxlg.app.service.ICostService;
import com.jxlg.app.service.ISerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-context.xml",
		"classpath:spring/spring-db.xml",
		"classpath:spring/spring-mvc.xml",
		"classpath:spring/spring-tx.xml"})
public class Test2 {
	//private Log log=null;
	
	@Resource(name="costService")
	private ICostService iCostService;
	{
		//log = LogFactory.getLog(Test2.class);
	}
	@Resource 
	private ISerService iSerService;
	@Resource
	private ICostDao iCostDao;
	@Resource
	private IAccountDao iAccount;
	
	
	@Test
	public void testSave(){
		Cost cost=new Cost();
		cost.setName("包60小时");
		cost.setBaseBuration(60);
		cost.setBaseCost(new BigDecimal(72.00));
		cost.setUnitCost(new BigDecimal(1.20));
		cost.setStatus("0");
		cost.setDescr("下午5点前下单,当天到账!");
		cost.setStartime(new Timestamp((new Date()).getTime()));
		cost.setCostType("3");
		iCostService.saveCost(cost);
	}
	
	@Test
	public void getAll(){
		//List<Cost> list = iCostService.allCost();
		//log.info("这是log信息---------->"+list);
		//System.out.println(list);
	}
	
	@Test
	public void time(){
//		List<Cost> list = iCostService.updateCost(2);
//		System.out.println(list.toString());
		long time = new Date().getTime();
		System.out.println(time);
	}
	
	@Test
	public void testSaveService(){
		Service service = new Service();
		service.setUnixHost("192.168.0.23");
		service.setOsUsername("bobo");
		service.setLoginPasswd("123456");
		Account account = new Account();
		account.setAccountId(22);
		service.setAccount(account);
		//service.setAccount(iAccount.findOne(22));
		Cost cost = new Cost();
		cost.setCostId(7);
		//service.setCost(iCostDao.findOne(7));
		service.setCost(cost);
		//System.out.println(service.getAccount().getLoginName());
		iSerService.save(service);
	}
	
	@Test
	public void testFindService(){
		UtilPage<Service> findAll = iSerService.findAll(0);
		System.out.println(findAll.getAll().get(0).getAccount());
		System.out.println(findAll.getAll().get(0).getCost());
		System.out.println(findAll);
	}
	

}
