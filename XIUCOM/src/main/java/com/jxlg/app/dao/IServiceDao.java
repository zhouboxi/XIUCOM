package com.jxlg.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jxlg.app.entity.Service;

public interface IServiceDao extends  JpaRepository<Service, Integer>,JpaSpecificationExecutor<Service>{

}
