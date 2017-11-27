package com.jxlg.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.jxlg.app.entity.BillItem;

public interface IBillItemDao extends JpaRepository<BillItem, Integer>,JpaSpecificationExecutor<BillItem>{

	@Query("From BillItem b where b.bill.billId=?1")
	List<BillItem> findByBillId(Integer billId);
}
