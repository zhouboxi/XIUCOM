package com.jxlg.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jxlg.app.entity.Bill;

public interface IBillDao extends JpaRepository<Bill, Integer>,JpaSpecificationExecutor<Bill>{

}
