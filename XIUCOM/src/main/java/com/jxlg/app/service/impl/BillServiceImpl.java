package com.jxlg.app.service.impl;

import java.util.ArrayList;
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

import com.jxlg.app.dao.IBillDao;
import com.jxlg.app.entity.Bill;
import com.jxlg.app.results.UtilPage;
import com.jxlg.app.service.IBillService;

@Service
public class BillServiceImpl implements IBillService {

	@Resource
	private IBillDao iBillDao;
	
	
	//保存
	@Override
	@Transactional(rollbackFor={Exception.class})
	public Bill save(Bill bill) {
		if(bill!=null){
			Bill bill2 = iBillDao.save(bill);
			return bill2;
		}
		return null;
	}

	//分页查询
	@Override
	public UtilPage<Bill> findAll(Integer pageNum) {
		 int pageSize=5;//一页5条记录
		 PageRequest pageRequest = new PageRequest(pageNum,pageSize);
		 Page<Bill> page = iBillDao.findAll(pageRequest);
		 UtilPage<Bill> utilPage = new UtilPage<>();
		 utilPage.setAll(page.getContent());
		 utilPage.setNumberOfPage(page.getNumberOfElements());
		 utilPage.setPageNumber(page.getNumber()+1);
		 utilPage.setTotalElements(page.getTotalElements());
		 utilPage.setTotalPages(page.getTotalPages());
		return utilPage;
	}

	//筛选查询
	@Override
	public UtilPage<Bill> search(String idcardNo, String loginName, String realName, String billMonth) {
		int pageSize=5;//一页5条记录
		PageRequest pageRequest = new PageRequest(0,pageSize);
		Page<Bill> page = iBillDao.findAll(new Specification<Bill>() {
			
			@Override
			public Predicate toPredicate(Root<Bill> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<>();
				if(idcardNo!=null&&!idcardNo.equals("")){
					list.add(cb.like(root.get("account").get("idcardNo").as(String.class),"%" + idcardNo + "%"));
				}
				if(loginName!=null&&!loginName.equals("")){
					list.add(cb.like(root.get("account").get("loginName").as(String.class),"%" + loginName + "%"));
				}
				if(realName!=null&&!realName.equals("")){
					list.add(cb.like(root.get("account").get("realName").as(String.class),"%" + realName + "%"));
				}
				if(idcardNo!=null&&!idcardNo.equals("")){
					list.add(cb.like(root.get("billMonth").as(String.class),"%" + billMonth + "%"));
				}
				Predicate[] p = new Predicate[list.size()];
				return cb.and(list.toArray(p));
			}
		},pageRequest);
		UtilPage<Bill> utilPage = new UtilPage<>();
		utilPage.setAll(page.getContent());
		utilPage.setNumberOfPage(page.getNumberOfElements());
		utilPage.setPageNumber(page.getNumber()+1);
		utilPage.setTotalElements(page.getTotalElements());
		utilPage.setTotalPages(page.getTotalPages());
		return utilPage;
	}
	
	

}
