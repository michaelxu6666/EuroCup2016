package com.xl.fm.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Privilege implements Serializable {
		
	private Long id;
	private String name;
	private String url;
	private String icon; //顶级菜单用的
	
	private Set<User> users = new HashSet<User>();
	private Privilege parent;
	private Set<Privilege> children = new HashSet<Privilege>();
	
	public Privilege() {
		
	}
	
	public Privilege(String name, String url, String icon, Privilege parent) {
		this.name = name;
		this.url = url;
		this.icon = icon;
		this.parent = parent;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Privilege getParent() {
		return parent;
	}
	public void setParent(Privilege parent) {
		this.parent = parent;
	}
	public Set<Privilege> getChildren() {
		return children;
	}
	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}
	
	
	
}
