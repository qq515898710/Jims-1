package org.mo.open.common.dto;

import org.mo.open.common.entity.User;
import org.mo.open.common.exception.MyRuntimeException;

public class RegisterDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String username;

	private java.lang.String password;

	private java.lang.String repassword;

	public User toObject() throws MyRuntimeException {
		try {
			return new User(username, password);
		} catch (Exception e) {
			throw new MyRuntimeException(getClass().getName() + " convert fail");
		}
	}

	public java.lang.String getUsername() {
		return username;
	}

	public void setUsername(java.lang.String username) {
		this.username = username;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public java.lang.String getRepassword() {
		return repassword;
	}

	public void setRepassword(java.lang.String repassword) {
		this.repassword = repassword;
	}

}
