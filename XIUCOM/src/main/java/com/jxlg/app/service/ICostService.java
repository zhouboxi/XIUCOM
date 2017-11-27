package com.jxlg.app.service;

import com.jxlg.app.entity.Cost;
import com.jxlg.app.results.UtilPage;

public interface ICostService {

	//	对数据的保存
	Cost saveCost(Cost cost);
	
	//对数据进行读取
	UtilPage<Cost> allCost(Integer pageNum);
	
	//对数据的服务的开通
	UtilPage<Cost> updateCost(Integer costId);
	
	//对数据的删除
	UtilPage<Cost> deleteCost(Integer costId);
	
	//通过id查询数据
	Cost findById(Integer costId);
	
	//通过id修改
	Boolean updateOne(Cost cost);
}
