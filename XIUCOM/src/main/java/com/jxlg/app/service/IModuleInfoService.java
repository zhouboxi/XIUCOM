package com.jxlg.app.service;

import com.jxlg.app.entity.ModuleInfo;
import com.jxlg.app.results.UtilPage;

public interface IModuleInfoService {
	void save(ModuleInfo moduleInfo);
	
	UtilPage<ModuleInfo> findAll();

}
