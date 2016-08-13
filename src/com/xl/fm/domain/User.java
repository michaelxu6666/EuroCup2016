package com.xl.fm.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

public class User implements Serializable {
	
	private Long id;
	private String loginName; //登录名
	private String password; //密码
	private String name; //真实姓名
	private String gender;
	
	private Set<Privilege> privileges = new HashSet<Privilege>(); //所拥有的权限
	
	/**
	 * 判断本用户是否有指定名称的权限
	 * @param privilegeName
	 * @return
	 */
	public boolean hasPrivilegeByName(String privilegeName) {
		//超级管理员有所有的权限
		if(isAdmin()) {
			return true;
		}
		
		//其他用户要是有权限才返回true
		for (Privilege privilege : privileges) {
			if (privilege.getName().equals(privilegeName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasPrivilegeUrl(String privilegeUrl) {
		if (isAdmin()) {
			return true;
		}
		
		//如果以UI结尾，就去掉UI后缀，以得到对应的权限（例如： addUI与add是同一个权限）
		if(privilegeUrl.endsWith("UI")) {
			privilegeUrl = privilegeUrl.substring(0, privilegeUrl.length() - 2);
		}
		
		//其他用户要有权限才返回true
		List<String> allPrivilegeUrls = (List<String>) ActionContext.getContext().getApplication().get("allPrivilegeUrls");
		if (!allPrivilegeUrls.contains(privilegeUrl)) {
			//如果不是需要控制的功能，则所有用户都可以使用
			return true;
		} else {
			//如果是要控制的功能，则有权限才能使用
			for (Privilege privilege : privileges ) {
				if (privilegeUrl.equals(privilege.getUrl())){
					return true;
				}
			}
			return false;
		}
		
	}
	
	
	public boolean isAdmin() {
		return "admin".equals(loginName);
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

}
