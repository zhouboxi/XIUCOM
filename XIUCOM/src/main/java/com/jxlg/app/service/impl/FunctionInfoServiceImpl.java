package com.jxlg.app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxlg.app.dao.IFunctionInfoDao;
import com.jxlg.app.entity.FunctionInfo;
import com.jxlg.app.service.IFunctionInfoService;
@Service
public class FunctionInfoServiceImpl implements IFunctionInfoService {

	@Resource
	private IFunctionInfoDao iFunctionInfoDao;
	@Override
	@Transactional(rollbackFor={Exception.class})
	public void save(FunctionInfo functionInfo) {
		iFunctionInfoDao.save(functionInfo);
	}

}
