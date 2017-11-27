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

import com.jxlg.app.dao.IBillItemDao;
import com.jxlg.app.entity.BillItem;
import com.jxlg.app.results.UtilPage;
import com.jxlg.app.service.IBillItemService;

@Service
public class BillItemServiceImpl implements IBillItemService {

	@Resource
	private IBillItemDao iBillItemDao;
	
	

	
	//保存详细账单
	@Override
	@Transactional(rollbackFor={Exception.class})
	public BillItem saveDetail(BillItem bill) {
		if(bill!=null){
			BillItem billItem = iBillItemDao.save(bill);
			return billItem;
		}
		return null;
	}

	//分页查询
	@Override
	public UtilPage<BillItem> search(Integer itemId) {
		int pageSize=5;//一页5条记录
		PageRequest pageRequest = new PageRequest(0,pageSize);
		Page<BillItem> page = iBillItemDao.findAll(new Specification<BillItem>() {
			@Override
			public Predicate toPredicate(Root<BillItem> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<>();
				if(itemId!=null&&!itemId.equals("")){
					list.add(cb.equal(root.get("bill").get("billId").as(Integer.class), itemId));
				}
				Predicate[] p = new Predicate[list.size()];
				return cb.and(list.toArray(p));
			}
		},pageRequest);
		UtilPage<BillItem> utilPage = new UtilPage<>();
		utilPage.setAll(page.getContent());
		utilPage.setNumberOfPage(page.getNumberOfElements());
		utilPage.setPageNumber(page.getNumber()+1);
		utilPage.setTotalElements(page.getTotalElements());
		utilPage.setTotalPages(page.getTotalPages());
		return utilPage;
	}
	

}
