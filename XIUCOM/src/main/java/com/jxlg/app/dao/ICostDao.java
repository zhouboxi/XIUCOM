package com.jxlg.app.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jxlg.app.entity.Cost;

public interface ICostDao extends JpaRepository<Cost, Integer> {

	//对数据的更新
	@Modifying
	@Query("update Cost c set c.status = ?1 , c.startime= ?2 where c.costId = ?3")
	int updateCost(String status, Timestamp startime,Integer costId);
	
	
	//对对象更新
	@Modifying
	@Query("update Cost c set c.name = ?1 , c.baseBuration= ?2,c.baseCost= ?3,"
			+ "c.unitCost= ?4,c.descr= ?5,c.costType= ?6 where c.costId = ?7")
	int updateOne(String name, Integer baseBuration,BigDecimal baseCost,
			BigDecimal unitCost,String descr,String costType ,Integer costId);

}
