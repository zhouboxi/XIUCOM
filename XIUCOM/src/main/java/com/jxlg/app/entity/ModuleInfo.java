package com.jxlg.app.entity;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author zhouboxi
 * @create 2017-11-01 9:04
 **/
@Entity
@Table(name = "module_info")
public class ModuleInfo {
    private Integer moduleId;
    private String name;
    private Set<FunctionInfo> functionInfos;
    private Set<RoleInfo> roleInfos;
    
    @Id
    @GeneratedValue
    @Column(name = "MODULE_ID")
    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    @OneToMany(mappedBy="moduleInfo",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<FunctionInfo> getFunctionInfos() {
		return functionInfos;
	}

	public void setFunctionInfos(Set<FunctionInfo> functionInfos) {
		this.functionInfos = functionInfos;
	}
	@JsonIgnore
	@ManyToMany(mappedBy = "moduleInfos",targetEntity = RoleInfo.class ,fetch = FetchType.LAZY)  
	public Set<RoleInfo> getRoleInfos() {
		return roleInfos;
	}

	public void setRoleInfos(Set<RoleInfo> roleInfos) {
		this.roleInfos = roleInfos;
	}

    
	
}

