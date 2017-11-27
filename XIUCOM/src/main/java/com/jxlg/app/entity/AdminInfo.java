package com.jxlg.app.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author zhouboxi
 * @create 2017-11-01 9:03
 **/
@Entity
@Table(name = "admin_info")
public class AdminInfo {
    private Integer adminId;
    private String adminCode;
    private String password;
    private String name;
    private String telephone;
    private String email;
    private Timestamp enrolldate;
    private Set<RoleInfo> roleInfos;

    @Id
    @GeneratedValue
    @Column(name = "ADMIN_ID")
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "ADMIN_CODE")
    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "ENROLLDATE")
    public Timestamp getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(Timestamp enrolldate) {
        this.enrolldate = enrolldate;
    }

    
    @ManyToMany(targetEntity = RoleInfo.class, fetch = FetchType.EAGER)
    @JoinTable(name = "T_ADMIN_ROLES", joinColumns = @JoinColumn(name = "Admin_Id"), inverseJoinColumns = @JoinColumn(name = "Role_Id")) 
	public Set<RoleInfo> getRoleInfos() {
		return roleInfos;
	}

	public void setRoleInfos(Set<RoleInfo> roleInfos) {
		this.roleInfos = roleInfos;
	}

   
  
}

