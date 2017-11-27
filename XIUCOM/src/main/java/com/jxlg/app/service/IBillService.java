package com.jxlg.app.service;

import com.jxlg.app.entity.Bill;
import com.jxlg.app.results.UtilPage;

public interface IBillService {
	
	public Bill save(Bill bill);
	
	public UtilPage<Bill> findAll(Integer pageNum);
	
	public UtilPage<Bill> search(String idcardNo,String loginName,String realName,String billMonth);


}
