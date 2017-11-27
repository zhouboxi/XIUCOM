package com.jxlg.app.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jxlg.app.util.DateJsonDeserializer;
import com.jxlg.app.util.DateJsonSerializer;

/**
 * @author zhouboxi
 * @create 2017-11-01 9:03
 **/
@Entity
@Table(name="ACCOUNT")
@DynamicInsert
@DynamicUpdate
public class Account {
    private Integer accountId;//账户id
    private Integer recommenderId;//推荐人账户id
    private String loginName;//登录系统名称
    private String loginPasswd;//密码
    private String status;//0开通 1暂停 2 删除
    private Timestamp creaDate;//创建日期
    private Date pauseDate;//暂停日期
    private Date closeDate;//删除日期
    private String realName;//真实名字
    private String idcardNo;//身份证
    @JsonSerialize(using=DateJsonSerializer.class)  
    @JsonDeserialize(using=DateJsonDeserializer.class)
    private Date birthdate;//生日
    private String gender;//0男 I女
    private String occupation;//职业
    private String telephone;//联系电话
    private String email;//电子邮箱
    private String mailaddress;//通信地址
    private String zipcode;//邮编
    private String qq;//QQ
    private Timestamp lastLoginTime;//最后一次登录
    private String lastLoginIp;//最后一次登录ip
    private Set<Service> services;

    @Id
    @GeneratedValue
    @Column(name = "ACCOUNT_ID")
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "RECOMMENDER_ID")
    public Integer getRecommenderId() {
        return recommenderId;
    }

    public void setRecommenderId(Integer recommenderId) {
        this.recommenderId = recommenderId;
    }

    @Basic
    @Column(name = "LOGIN_NAME")
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    @Basic
    @Column(name = "REAL_NAME")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "IDCARD_NO")
    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    @Basic
    @Column(name = "BIRTHDATE")
    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "GENDER")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "OCCUPATION")
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Basic
    @Column(name = "TELEPHONE")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "MAILADDRESS")
    public String getMailaddress() {
        return mailaddress;
    }

    public void setMailaddress(String mailaddress) {
        this.mailaddress = mailaddress;
    }

    @Basic
    @Column(name = "ZIPCODE")
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "QQ")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "LAST_LOGIN_TIME")
    public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}
    

    public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    @Basic
    @Column(name = "LAST_LOGIN_IP")
    public String getLastLoginIp() {
        return lastLoginIp;
    }
    @JsonIgnore
    @OneToMany(cascade={CascadeType.ALL},mappedBy="account")
	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}
    
    

}

