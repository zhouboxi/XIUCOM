package com.jxlg.app.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxlg.app.dao.IModuleInfoDao;
import com.jxlg.app.entity.ModuleInfo;
import com.jxlg.app.results.UtilPage;
import com.jxlg.app.service.IModuleInfoService;
@Service
public class ModuleInfoServiceImpl implements IModuleInfoService {

	@Resource
	private IModuleInfoDao iModuleInfoDao;
	
	@Override
	@Transactional(rollbackFor={Exception.class})
	public void save(ModuleInfo moduleInfo) {
		iModuleInfoDao.save(moduleInfo);
	}

	@Override
	public UtilPage<ModuleInfo> findAll() {
		int pageSize=5;//一页5条记录
		PageRequest pageRequest = new PageRequest(0,pageSize);
		Page<ModuleInfo> page = iModuleInfoDao.findAll(pageRequest);
		UtilPage<ModuleInfo> utilPage = new UtilPage<>();
		utilPage.setAll(page.getContent());
		utilPage.setNumberOfPage(page.getNumberOfElements());
		utilPage.setPageNumber(page.getNumber()+1);
		utilPage.setTotalElements(page.getTotalElements());
		utilPage.setTotalPages(page.getTotalPages());
		return utilPage;
	}

}
