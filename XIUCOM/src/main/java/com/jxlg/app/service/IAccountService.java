package com.jxlg.app.service;

import com.jxlg.app.entity.Account;
import com.jxlg.app.results.UtilPage;

public interface IAccountService extends IBaseService<Account>{
	
	//搜索功能
	UtilPage<Account> search(String idcardNo,String realName,String loginName,String status);

	Account  findByIdCard(String idcard);

}
