/***********************************************************************
 * Module:  TbUserLog.java
 * Author:  YK
 * Purpose: Defines the Class TbUserLog
 ***********************************************************************/
package org.mo.open.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录日志信息
 * 
 */
public class UserLog implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private java.util.Date loginTime;

	private User user;

	public UserLog() {
		super();
	}

	public UserLog(long id, Date loginTime, User user) {
		super();
		this.id = id;
		this.loginTime = loginTime;
		this.user = user;
	}

	public UserLog(User user) {
		super();
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public java.util.Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(java.util.Date loginTime) {
		this.loginTime = loginTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}