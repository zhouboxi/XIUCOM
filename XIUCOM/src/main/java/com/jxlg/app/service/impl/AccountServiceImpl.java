package com.jxlg.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxlg.app.dao.IAccountDao;
import com.jxlg.app.entity.Account;
import com.jxlg.app.results.UtilPage;
import com.jxlg.app.service.IAccountService;
@Service
public class AccountServiceImpl implements IAccountService {

	@Resource
	private IAccountDao iAccount;
	
	
	//用户的保存
	@Override
	@Transactional(rollbackFor={Exception.class})
	public Account save(Account t) {
		Account account2 = iAccount.save(t);
		return account2;
	}

	//查询所有的信息
	@Override
	public UtilPage<Account> findAll(Integer pageNum) {
		 int pageSize=5;//一页5条记录
		 PageRequest pageRequest = new PageRequest(pageNum,pageSize);
		 Page<Account> page = iAccount.findAll(pageRequest);
		 UtilPage<Account> utilPage = new UtilPage<>();
		 utilPage.setAll(page.getContent());
		 utilPage.setNumberOfPage(page.getNumberOfElements());
		 utilPage.setPageNumber(page.getNumber()+1);
		 utilPage.setTotalElements(page.getTotalElements());
		 utilPage.setTotalPages(page.getTotalPages());
		return utilPage;
	}

	//开通和暂停
	@Override
	public UtilPage<Account> update(Integer id,String state) {
		Account account = findById(id);
		account.setStatus(state);
		if(state.equals("1")){
			account.setPauseDate(new Date());
		}
		if(state.equals("0")){
			account.setPauseDate(null);
		}
		iAccount.save(account);
		UtilPage<Account> utilPage = findAll(0);
		return utilPage;
	}

	//把状态标记为删除
	@Override
	@Transactional(rollbackFor={Exception.class})
	public UtilPage<Account> delete(Integer id) {
		Account account = findById(id);
		account.setStatus("2");
		account.setCloseDate(new Date());
		iAccount.save(account);
		UtilPage<Account> utilPage = findAll(0);
		return utilPage;
	}


	@Override
	public Account findById(Integer id) {
		Account account = iAccount.findOne(id);
		return account;
	}


	@Override
	@Transactional(rollbackFor={Exception.class})
	public Boolean updateOne(Account t) {
		Account findById = findById(t.getAccountId());
		findById.setRealName(t.getRealName());
		findById.setTelephone(t.getTelephone());
		findById.setEmail(t.getEmail());
		findById.setOccupation(t.getOccupation());
		findById.setGender(t.getGender());
		findById.setMailaddress(t.getMailaddress());
		findById.setZipcode(t.getZipcode());
		findById.setQq(t.getQq());
		findById.setRecommenderId(t.getRecommenderId());
		Account account = iAccount.save(findById);
		if(account!=t){
			return true;
		}
		return false;
	}

	@Override
	public UtilPage<Account> search(String idcardNo, String realName, String loginName, String status) {
		//Assert.notNull(model);
		 int pageSize=5;//一页5条记录
		 PageRequest pageRequest = new PageRequest(0,pageSize);
		
		Page<Account> page = iAccount.findAll(new Specification<Account>() {
			
			@Override
			public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				 List<Predicate> list = new ArrayList<Predicate>();
				 
				if(idcardNo!=null&&!idcardNo.equals("")){
					 list.add(cb.like(root.get("idcardNo").as(String.class), "%" + idcardNo + "%"));
				}
				if(realName!=null&&!realName.equals("")){
					 list.add(cb.like(root.get("realName").as(String.class), "%" + realName + "%"));
				}
				if(loginName!=null&&!loginName.equals("")){
					 list.add(cb.like(root.get("loginName").as(String.class), "%" + loginName + "%"));
				}
				if(status!=null&&!status.equals("")){
					 list.add(cb.like(root.get("status").as(String.class), "%" + status + "%"));
				}
				 Predicate[] p = new Predicate[list.size()];
				 return cb.and(list.toArray(p));
			}
		},pageRequest);
		UtilPage<Account> utilPage = new UtilPage<>();
		 utilPage.setAll(page.getContent());
		 utilPage.setNumberOfPage(page.getNumberOfElements());
		 utilPage.setPageNumber(page.getNumber()+1);
		 utilPage.setTotalElements(page.getTotalElements());
		 utilPage.setTotalPages(page.getTotalPages());
		return utilPage;
	}

	@Override
	public Account findByIdCard(String idcard) {
		Account account = iAccount.findByIdcardNo(idcard);
		return account;
	}

}
