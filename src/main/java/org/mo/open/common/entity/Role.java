package org.mo.open.common.entity;

import java.util.List;

/**
 * 角色表
 * 
 * @author moziqi
 *
 */
public class Role implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private java.lang.Long id;

	private java.lang.String name;

	private java.lang.String description;

	private List<User> user;

	private List<Permission> permission;
	
	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Permission> getPermission() {
		return permission;
	}

	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}

}
