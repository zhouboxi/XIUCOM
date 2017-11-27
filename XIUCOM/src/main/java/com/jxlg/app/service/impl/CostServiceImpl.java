package com.jxlg.app.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxlg.app.dao.ICostDao;
import com.jxlg.app.entity.Cost;
import com.jxlg.app.results.UtilPage;
import com.jxlg.app.service.ICostService;
@Service("costService")
public class CostServiceImpl implements ICostService {

	@Resource
	private ICostDao iCostDao;
	
	//添加数据
	@Override
	@Transactional(rollbackFor={Exception.class})
	public Cost saveCost(Cost cost) {
		Cost cost2 = iCostDao.saveAndFlush(cost);
		return cost2;
	}

	//查询所有
	@Override
	public UtilPage<Cost> allCost(Integer pageNum) {
		//int pageNO=0;//第1页从0开始
	    int pageSize=5;//一页5条记录
		PageRequest pageRequest = new PageRequest(pageNum,pageSize);
		Page<Cost> findAll = iCostDao.findAll(pageRequest);
		UtilPage<Cost> utilPage = new UtilPage<>();
		utilPage.setAll(findAll.getContent());
		utilPage.setTotalPages(findAll.getTotalPages());
		utilPage.setPageNumber(findAll.getNumber()+1);
		utilPage.setTotalElements(findAll.getTotalElements());
		utilPage.setNumberOfPage(findAll.getNumberOfElements());
		return utilPage;
	}

	//对业务开启
	@Override
	@Transactional(rollbackFor={Exception.class})
	public UtilPage<Cost> updateCost(Integer costId) {
		int i = iCostDao.updateCost("0", new Timestamp((new Date()).getTime()), costId);
		if(i>0){
			UtilPage<Cost> utilPage=allCost(0);
			return utilPage;
		}
		return null;
	}

	//通过id删除
	@Override
	@Transactional(rollbackFor={Exception.class})
	public UtilPage<Cost> deleteCost(Integer costId) {
		iCostDao.delete(costId);
		UtilPage<Cost> utilPage = allCost(0);
		return utilPage;
	}

	//通过id查找
	@Override
	public Cost findById(Integer costId) {
		Cost cost = iCostDao.findOne(costId);
		return cost;
	}

	//更新一个对象
	@Override
	@Transactional(rollbackFor={Exception.class})
	public Boolean updateOne(Cost cost) {
		int i = iCostDao.updateOne(cost.getName(), cost.getBaseBuration(), cost.getBaseCost(),
				cost.getUnitCost(), cost.getDescr(), cost.getCostType(), cost.getCostId());
		if(i>0){
			return true;
		}
		return false;
	}

	
	


}
