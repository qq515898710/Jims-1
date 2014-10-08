/***********************************************************************
 * Module:  TbUserRole.java
 * Author:  YK
 * Purpose: Defines the Class TbUserRole
 ***********************************************************************/
package org.mo.open.common.entity;

import java.io.Serializable;

/**
 * 用户与角色关系表
 * 
 */
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user;
	
	private Role role;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}