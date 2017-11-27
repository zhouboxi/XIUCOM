package com.jxlg.app.service;

import com.jxlg.app.results.UtilPage;

public interface IBaseService<T> {
	//	对数据的保存
	T save(T t);
	
	//对数据进行读取
	UtilPage<T> findAll(Integer pageNum);
	
	//对数据的服务的开通
	UtilPage<T> update(Integer id,String state);
	
	//对数据的删除
	UtilPage<T> delete(Integer id);
	
	//通过id查询数据
	T findById(Integer id);
	
	//通过id修改
	Boolean updateOne(T t);
	
	//搜索功能
	UtilPage<T> search(String idcardNo,String realName,String loginName,String status);

}
