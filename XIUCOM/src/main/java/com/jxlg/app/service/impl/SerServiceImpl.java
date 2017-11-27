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
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import com.jxlg.app.dao.IServiceDao;
import com.jxlg.app.entity.Service;
import com.jxlg.app.results.UtilPage;
import com.jxlg.app.service.ISerService;

@org.springframework.stereotype.Service
public class SerServiceImpl implements ISerService {

	@Resource
	private IServiceDao iServiceDao;
	
	@Override
	@Transactional(rollbackFor={Exception.class})
	public Service save(Service t){
		Service save = iServiceDao.save(t);
		return save;
	}

	@Override
	public UtilPage<Service> findAll(Integer pageNum) {
		 int pageSize=5;//一页5条记录
		 PageRequest pageRequest = new PageRequest(pageNum,pageSize);
		 Page<Service> page = iServiceDao.findAll(pageRequest);
		 UtilPage<Service> utilPage = new UtilPage<>();
		 utilPage.setAll(page.getContent());
		 utilPage.setNumberOfPage(page.getNumberOfElements());
		 utilPage.setPageNumber(page.getNumber()+1);
		 utilPage.setTotalElements(page.getTotalElements());
		 utilPage.setTotalPages(page.getTotalPages());
		return utilPage;
	}
	
	
	@Override
	public UtilPage<Service> update(Integer id, String state) {
		Service service = findById(id);
		service.setStatus(state);
		if(state.equals("1")){
			service.setPauseDate(new Date());
		}
		if(state.equals("0")){
			service.setPauseDate(null);
		}
		iServiceDao.save(service);
		UtilPage<Service> utilPage = findAll(0);
		return utilPage;
	}

	@Override
	@Transactional(rollbackFor={Exception.class})
	public UtilPage<Service> delete(Integer id) {
		Service service = findById(id);
		service.setStatus("2");
		service.setCloseDate(new Date());
		iServiceDao.save(service);
		UtilPage<Service> utilPage = findAll(0);
		return utilPage;
	}

	@Override
	public Service findById(Integer id) {
		Service service = iServiceDao.findOne(id);
		return service;
	}

	@Override
	@Transactional(rollbackFor={Exception.class})
	public Boolean updateOne(Service t) {
		Service service = findById(t.getServiceId());
		service.setCost(t.getCost());
		Service service2 = iServiceDao.save(service);
		if(service2!=t){
			return true;
		}
		return false;
	}

	@Override
	public UtilPage<Service> search(String osUsername, String unixHost, String idcardNo, String status) {
		 int pageSize=5;//一页5条记录
		 Sort.Order order = new Sort.Order(Sort.Direction.ASC, "serviceId");
		 Sort sort = new Sort(order);
		 PageRequest pageRequest = new PageRequest(0, pageSize, sort);
		 Page<Service> page = iServiceDao.findAll(new Specification<Service>() {

			@Override
			public Predicate toPredicate(Root<Service> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();
				if(osUsername!=null&&!osUsername.equals("")){
					 list.add(cb.like(root.get("osUsername").as(String.class), "%" + osUsername + "%"));
				}
				if(unixHost!=null&&!unixHost.equals("")){
					 list.add(cb.like(root.get("unixHost").as(String.class), "%" + unixHost + "%"));
				}
				if(idcardNo!=null&&!idcardNo.equals("")){
					 list.add(cb.like(root.get("account").get("idcardNo").as(String.class), "%" + idcardNo + "%"));
				}
				if(status!=null&&!status.equals("")){
					 list.add(cb.like(root.get("status").as(String.class), "%" + status + "%"));
				}
				Predicate[] p = new Predicate[list.size()];
				return cb.and(list.toArray(p));
			}
		},pageRequest);
		 UtilPage<Service> utilPage = new UtilPage<>();
		 utilPage.setAll(page.getContent());
		 utilPage.setNumberOfPage(page.getNumberOfElements());
		 utilPage.setPageNumber(page.getNumber()+1);
		 utilPage.setTotalElements(page.getTotalElements());
		 utilPage.setTotalPages(page.getTotalPages());
		return utilPage;
	}

}
