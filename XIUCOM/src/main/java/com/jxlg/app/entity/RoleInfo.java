package com.jxlg.app.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author zhouboxi
 * @create 2017-11-01 9:04
 **/
@Entity
@Table(name = "role_info")
public class RoleInfo {
    private Integer roleId;
    private String name;
    private Set<AdminInfo> adminInfos;
    private Set<ModuleInfo> moduleInfos;

    @Id
    @GeneratedValue
    @Column(name = "ROLE_ID")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JsonIgnore
    @ManyToMany(mappedBy = "roleInfos",targetEntity = AdminInfo.class)  
	public Set<AdminInfo> getAdminInfos() {
		return adminInfos;
	}

	public void setAdminInfos(Set<AdminInfo> adminInfos) {
		this.adminInfos = adminInfos;
	}

    
    @ManyToMany(targetEntity = ModuleInfo.class,fetch=FetchType.EAGER)
    @JoinTable(name = "T_Module_ROLES", joinColumns = @JoinColumn(name = "Role_Id"), inverseJoinColumns = @JoinColumn(name = "Module_Id")) 
    public Set<ModuleInfo> getModuleInfos() {
		return moduleInfos;
	}

	public void setModuleInfos(Set<ModuleInfo> moduleInfos) {
		this.moduleInfos = moduleInfos;
	}

    
}

