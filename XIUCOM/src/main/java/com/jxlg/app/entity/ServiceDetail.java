package com.jxlg.app.entity;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author zhouboxi
 * @create 2017-11-01 9:04
 **/
@Entity
@Table(name = "service_detail")
public class ServiceDetail {
    private Integer detailId;
    private String clientHost;
    private String osUsername;
    private Integer pid;
    private Date loginTime;
    private Date logoutTime;
    private BigDecimal duration;
    private BigDecimal cost;
    private Service service;

    @Id
    @GeneratedValue
    @Column(name = "DETAIL_ID")
    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    @Basic
    @Column(name = "CLIENT_HOST")
    public String getClientHost() {
        return clientHost;
    }

    public void setClientHost(String clientHost) {
        this.clientHost = clientHost;
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
    @Column(name = "PID")
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "LOGIN_TIME")
    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    @Basic
    @Column(name = "LOGOUT_TIME")
    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    @Basic
    @Column(name = "DURATION")
    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
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
    @JoinColumn(name = "SERVICE_ID", referencedColumnName = "SERVICE_ID", nullable = false)
    public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
}

