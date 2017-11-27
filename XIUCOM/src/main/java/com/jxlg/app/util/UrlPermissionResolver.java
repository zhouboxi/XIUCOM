package com.jxlg.app.util;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

public class UrlPermissionResolver implements PermissionResolver{
	/**
     * 经过调试发现
     * subject.isPermitted(url) 中传入的字符串
     * 和自定义 Realm 中传入的权限字符串集合都要经过这个 resolver
     * @param s
     * @return
     * 可以看到，权限信息是通过字符串：“/admin/**”等来进行匹配的。
     * 这时就不能使用 Shiro 默认的权限匹配器 WildcardPermission 了。
     * 而 UrlPermission 是一个实现了 Permission 接口的类
     * ，它的 implies 方法的实现决定了权限是否匹配，所以 implies 这个方法的实现是很重要的。
     */
	@Override
	public Permission resolvePermission(String s) {
		if(s.startsWith("/")){
            return new UrlPermission(s);
        }
        return new WildcardPermission(s);
	}

}
