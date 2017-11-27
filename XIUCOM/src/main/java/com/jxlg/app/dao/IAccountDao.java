package com.jxlg.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jxlg.app.entity.Account;

public interface IAccountDao extends JpaRepository<Account, Integer>,JpaSpecificationExecutor<Account>{

	
	Account findByIdcardNo(String idcard);
}
