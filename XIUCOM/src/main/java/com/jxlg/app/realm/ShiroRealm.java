package com.jxlg.app.realm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import com.jxlg.app.entity.AdminInfo;
import com.jxlg.app.entity.FunctionInfo;
import com.jxlg.app.entity.ModuleInfo;
import com.jxlg.app.entity.RoleInfo;
import com.jxlg.app.service.IAdminInfoService;

public class ShiroRealm extends AuthorizingRealm{
	@Resource
	private IAdminInfoService iAdminInfoService;
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// 获得经过认证的主体信息
		String name = (String)principalCollection.getPrimaryPrincipal();
        AdminInfo findById = iAdminInfoService.findByName(name);
        Set<RoleInfo> roleInfos = findById.getRoleInfos();
        List<String> roleSnList = new ArrayList<>();
        List<String> urlStrList = new ArrayList<>();;
       for (RoleInfo roleInfo : roleInfos) {
    	   roleSnList.add(roleInfo.getName());
    	   Set<ModuleInfo> infos = roleInfo.getModuleInfos();
    	   for (ModuleInfo moduleInfo : infos) {
    		   Set<FunctionInfo> functionInfos = moduleInfo.getFunctionInfos();
    		   for (FunctionInfo functionInfo : functionInfos) {
    			   String url = functionInfo.getUrl();
    			   urlStrList.add(url);
			}
		}
       }

       	SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(new HashSet<>(roleSnList));
        info.setStringPermissions(new HashSet<>(urlStrList));
        return info;
	}
	
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		 //1. 把 AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        //2. 从 UsernamePasswordToken 中来获取 username
        String username = upToken.getUsername();
        //3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
        AdminInfo adminInfo = iAdminInfoService.findByName(username);
        if (adminInfo==null||adminInfo.equals("")) {
        	throw new UnknownAccountException("用户不存在!");
		} 
        //6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        //以下信息是从数据库中获取的.
        //1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        Object principal = adminInfo.getAdminCode();
        //2). credentials: 密码.
        Object credentials = adminInfo.getPassword();
        //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
        String realmName = getName();

        SimpleAuthenticationInfo info = null; //new SimpleAuthenticationInfo(principal, credentials, realmName);
        info = new SimpleAuthenticationInfo(principal, credentials, realmName);
        return info;
	}
	
	//清除【认证】缓存
	@Override
	protected void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		 Cache c = getAuthenticationCache();
		    //清除【认证】缓存之前
		    for(Object o : c.keys()){
		        System.out.println( o + " , " + c.get(o));
		    }
		super.clearCachedAuthenticationInfo(principals);
		//调用父类清除【认证】缓存之后
		 for(Object o : c.keys()){
		        System.out.println( o + " , " + c.get(o));
		    }
		// 添加下面的代码清空【认证】的缓存
		String  adminInfo = (String) principals.getPrimaryPrincipal();
	    SimplePrincipalCollection spc = new SimplePrincipalCollection(adminInfo,getName());
	    super.clearCachedAuthenticationInfo(spc);
	    //"添加了代码清除【认证】缓存之后"
	    int cacheSize = c.keys().size();
	    System.out.println("【认证】缓存的大小:" + c.keys().size());
	    if (cacheSize == 0){
	    	System.out.println("说明【认证】缓存被清空了。");
	    }
	}
	
	//清除【授权】
	@Override
	protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		 //"清除【授权】缓存之前
		 Cache c = getAuthorizationCache();
		 for(Object o : c.keys()){
			 System.out.println( o + " , " + c.get(o));
		 }
		 super.clearCachedAuthorizationInfo(principals);
		 //"清除【授权】缓存之后"
		 int cacheSize = c.keys().size();
		 System.out.println("【授权】缓存的大小:" + c.keys().size());
		 for(Object o : c.keys()){
			 System.out.println( o + " , " + c.get(o));
		 }
		 if(cacheSize == 0){
			 System.out.println("说明【授权】缓存被清空了。");
		 }

	}

}
