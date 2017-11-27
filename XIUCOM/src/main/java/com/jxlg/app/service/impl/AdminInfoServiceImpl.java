package com.jxlg.app.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jxlg.app.dao.IAdminInfoDao;
import com.jxlg.app.entity.AdminInfo;
import com.jxlg.app.results.UtilPage;
import com.jxlg.app.service.IAdminInfoService;
@Service
public class AdminInfoServiceImpl implements IAdminInfoService {
	@Resource
	private IAdminInfoDao iAdminInfoDao;

	@Override
	public AdminInfo findByName(String name) {
		AdminInfo adminInfo = iAdminInfoDao.findByAdminCode(name);
		return adminInfo;
	}
	
	
	@Override
	public UtilPage<AdminInfo> findAll() {
		int pageSize=5;//一页5条记录
		PageRequest pageRequest = new PageRequest(0,pageSize);
		Page<AdminInfo> page = iAdminInfoDao.findAll(pageRequest);
		UtilPage<AdminInfo> utilPage = new UtilPage<>();
		utilPage.setAll(page.getContent());
		utilPage.setNumberOfPage(page.getNumberOfElements());
		utilPage.setPageNumber(page.getNumber()+1);
		utilPage.setTotalElements(page.getTotalElements());
		utilPage.setTotalPages(page.getTotalPages());
		return utilPage;
	}

	@Override
	public AdminInfo findById(Integer id) {
		AdminInfo findOne = iAdminInfoDao.findOne(id);
		return findOne;
	}


	@Override
	public Boolean save(AdminInfo adminInfo) {
		AdminInfo save = iAdminInfoDao.save(adminInfo);
		if(save==adminInfo){
			return true;
		}
		return false;
	}

}
