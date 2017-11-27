package com.jxlg.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxlg.app.dao.IRoleInfoDao;
import com.jxlg.app.entity.RoleInfo;
import com.jxlg.app.results.UtilPage;
import com.jxlg.app.service.IRoleInfoService;
@Service
public class RoleInfoServiceImpl implements IRoleInfoService {

	@Resource
	private IRoleInfoDao iRoleInfoDao;
	
	@Override
	public RoleInfo findByName(String name) {
		RoleInfo roleInfo = iRoleInfoDao.findByName(name);
		return roleInfo;
	}

	
	@Override
	@Transactional(rollbackFor={Exception.class})
	public Boolean save(RoleInfo roleInfo) {
		System.out.println(roleInfo.getName());
		RoleInfo name = findByName(roleInfo.getName());
		if(name!=null){
			name.setModuleInfos(roleInfo.getModuleInfos());
			RoleInfo info = iRoleInfoDao.save(name);
			if(info==roleInfo){
				return true;
			}
		}else{
			if(roleInfo.getName()!=null&&!roleInfo.getName().equals("")){
				iRoleInfoDao.save(roleInfo);
				return true;
			}
		}
		return false;
	}


	@Override
	public UtilPage<RoleInfo> findAll() {
		int pageSize=5;//一页5条记录
		PageRequest pageRequest = new PageRequest(0,pageSize);
		Page<RoleInfo> page = iRoleInfoDao.findAll(pageRequest);
		UtilPage<RoleInfo> utilPage = new UtilPage<>();
		utilPage.setAll(page.getContent());
		utilPage.setNumberOfPage(page.getNumberOfElements());
		utilPage.setPageNumber(page.getNumber()+1);
		utilPage.setTotalElements(page.getTotalElements());
		utilPage.setTotalPages(page.getTotalPages());
		return utilPage;
	}


	@Override
	public List<RoleInfo> findAllByadd() {
		List<RoleInfo> findAll = iRoleInfoDao.findAllBySql();
		return findAll;
	}


	@Override
	@Transactional(rollbackFor={Exception.class})
	public UtilPage<RoleInfo> delete(Integer roleId) {
		iRoleInfoDao.delete(roleId);
		UtilPage<RoleInfo> findAll = findAll();
		return findAll;
	}


	@Override
	public RoleInfo findById(Integer roleId) {
		RoleInfo findOne = iRoleInfoDao.findOne(roleId);
		return findOne;
	}


}
