package com.xl.fm.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

public class User implements Serializable {
	
	private Long id;
	private String loginName; //��¼��
	private String password; //����
	private String name; //��ʵ����
	private String gender;
	
	private Set<Privilege> privileges = new HashSet<Privilege>(); //��ӵ�е�Ȩ��
	
	/**
	 * �жϱ��û��Ƿ���ָ�����Ƶ�Ȩ��
	 * @param privilegeName
	 * @return
	 */
	public boolean hasPrivilegeByName(String privilegeName) {
		//��������Ա�����е�Ȩ��
		if(isAdmin()) {
			return true;
		}
		
		//�����û�Ҫ����Ȩ�޲ŷ���true
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
		
		//�����UI��β����ȥ��UI��׺���Եõ���Ӧ��Ȩ�ޣ����磺 addUI��add��ͬһ��Ȩ�ޣ�
		if(privilegeUrl.endsWith("UI")) {
			privilegeUrl = privilegeUrl.substring(0, privilegeUrl.length() - 2);
		}
		
		//�����û�Ҫ��Ȩ�޲ŷ���true
		List<String> allPrivilegeUrls = (List<String>) ActionContext.getContext().getApplication().get("allPrivilegeUrls");
		if (!allPrivilegeUrls.contains(privilegeUrl)) {
			//���������Ҫ���ƵĹ��ܣ��������û�������ʹ��
			return true;
		} else {
			//�����Ҫ���ƵĹ��ܣ�����Ȩ�޲���ʹ��
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
