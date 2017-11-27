package com.jxlg.app.util;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;

public class UrlPermission implements Permission {
	// 在 Realm 的授权方法中,由数据库查询出来的权限字符串
    private String url;

    public UrlPermission(String url){
        this.url = url;
    }
    /**
     * 一个很重要的方法,用户判断 Realm 中设置的权限和从数据库或者配置文件中传递进来的权限信息是否匹配
     * 如果 Realm 的授权方法中，一个认证主体有多个权限，会进行遍历，直到匹配成功为止
     * this.url 是在遍历状态中变化的
     *
     * urlPermission.url 是从 subject.isPermitted(url)
     * 传递到 UrlPermissionResolver 中传递过来的,就一个固定值
     *
     * @param permission
     * @return
     */
	@Override
	public boolean implies(Permission permission) {
		if(!(permission instanceof UrlPermission)){
            return false;
        }
		UrlPermission urlPermission = (UrlPermission)permission;
        PatternMatcher patternMatcher = new AntPathMatcher();
        boolean matches = patternMatcher.matches(this.url,urlPermission.url);
        return matches;
    }

}
