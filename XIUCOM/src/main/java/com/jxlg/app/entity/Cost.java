package com.jxlg.app.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author zhouboxi
 * @create 2017-11-01 9:04
 **/
@Entity
@Table(name = "COST")
@DynamicInsert
@DynamicUpdate
public class Cost {
	private Integer costId;// 资费ID
	private String name;// 资费名称
	private Integer baseBuration;// 在线时长
	private BigDecimal baseCost;// 月固定费
	private BigDecimal unitCost;// 单位费用
	private String status;// 0开通 1暂停
	private String descr;// 对资费信息的说明
	private Timestamp creatime;// 创建时间
	private Timestamp startime;// 开通日期
	private String costType;// 1包月2套餐3计时

	@Id
	@GeneratedValue
	@Column(name = "COST_ID")
	public Integer getCostId() {
		return costId;
	}

	public void setCostId(Integer costId) {
		this.costId = costId;
	}

	@Basic
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "BASE_BURATION")
	public Integer getBaseBuration() {
		return baseBuration;
	}

	public void setBaseBuration(Integer baseBuration) {
		this.baseBuration = baseBuration;
	}

	@Basic
	@Column(name = "BASE_COST",precision=7,scale=2)
	public BigDecimal getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(BigDecimal baseCost) {
		this.baseCost = baseCost;
	}
	
	@Basic
	@Column(name = "UNIT_COST",precision=9,scale=2)
	public BigDecimal getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}
	

	@Basic
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}
	

	public void setStatus(String status) {
		this.status = status;
	}

	@Basic
	@Column(name = "DESCR")
	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Basic
	@Column(name = "CREATIME")
	public Timestamp getCreatime() {
		return creatime;
	}

	public void setCreatime(Timestamp creatime) {
		this.creatime = creatime;
	}

	@Basic
	@Column(name = "STARTIME")
	public Timestamp getStartime() {
		return startime;
	}

	public void setStartime(Timestamp startime) {
		this.startime = startime;
	}

	@Basic
	@Column(name = "COST_TYPE")
	public String getCostType() {
		return costType;
	}

	

	public void setCostType(String costType) {
		this.costType = costType;
	}

	
	

}
