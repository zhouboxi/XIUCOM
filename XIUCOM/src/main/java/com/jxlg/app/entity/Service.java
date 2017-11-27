package com.jxlg.app.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author zhouboxi
 * @create 2017-11-01 9:04
 **/
@Entity
@DynamicInsert
@Table(name="SERVICE")
@DynamicUpdate
public class Service {
    private Integer serviceId;
    private String unixHost;
    private String osUsername;
    private String loginPasswd;
    private String status;
    private Timestamp creaDate;
    private Date pauseDate;
    private Date closeDate;
    private Account account;
    private Cost cost;


	@Id
    @GeneratedValue
    @Column(name = "SERVICE_ID")
    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "UNIX_HOST")
    public String getUnixHost() {
        return unixHost;
    }

    public void setUnixHost(String unixHost) {
        this.unixHost = unixHost;
    }

    @Basic
    @Column(name = "OS_USERNAME")
    public String getOsUsername() {
        return osUsername;
    }

    public void setOsUsername(String osUsername) {
        this.osUsername = osUsername;
    }

    @Basic
    @Column(name = "LOGIN_PASSWD")
    public String getLoginPasswd() {
        return loginPasswd;
    }

    public void setLoginPasswd(String loginPasswd) {
        this.loginPasswd = loginPasswd;
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
    @Column(name = "CREA_DATE")
    public Timestamp getCreaDate() {
        return creaDate;
    }

    public void setCreaDate(Timestamp creaDate) {
        this.creaDate = creaDate;
    }

    @Basic
    @Column(name = "PAUSE_DATE")
    public Date getPauseDate() {
        return pauseDate;
    }

    public void setPauseDate(Date pauseDate) {
        this.pauseDate = pauseDate;
    }

    @Basic
    @Column(name = "CLOSE_DATE")
    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }



    @ManyToOne(cascade={CascadeType.REFRESH},fetch=FetchType.EAGER)
    @JoinColumn(name = "ACCOUNT_ID")
    public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

    @ManyToOne(cascade={CascadeType.REFRESH},fetch=FetchType.EAGER)
    @JoinColumn(name = "COST_ID", referencedColumnName = "COST_ID", nullable = false)
	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}

	

   
}

