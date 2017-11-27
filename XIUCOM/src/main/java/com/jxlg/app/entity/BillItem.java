package com.jxlg.app.entity;

import java.math.BigDecimal;

import javax.persistence.*;

/**
 * @author zhouboxi
 * @create 2017-11-01 9:04
 **/
@Entity
@Table(name = "bill_item")
public class BillItem {
    private Integer itemId;
    private BigDecimal cost;
    private Bill bill;
    private Service service;

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "COST")
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

   
   @ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
   @JoinColumn(name = "BILL_ID", referencedColumnName = "BILL_ID", nullable = false)
   public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name = "SERVICE_ID", referencedColumnName = "SERVICE_ID", nullable = false)
	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

}

