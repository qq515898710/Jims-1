/***********************************************************************
 * Module:  TbUserLog.java
 * Author:  YK
 * Purpose: Defines the Class TbUserLog
 ***********************************************************************/
package org.mo.open.common.entity;

import java.io.Serializable;

/**
 * 登录日志信息
 * 
 */
public class UserLog implements Serializable{


	private static final long serialVersionUID = 1L;

	private long id;

	private java.util.Date time;

	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public java.util.Date getTime() {
		return time;
	}

	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}