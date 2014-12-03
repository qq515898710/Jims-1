package org.mo.open.common.dto;

import org.mo.open.common.entity.User;

public class UserDTO implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String account;
	
	private String username;
	
	private String roleName;

	private String password;

	public User toAddObject(){
		User user = new User();
		user.setAccount(account);
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}
	
	public User toEditObject(){
		User user = new User();
		user.setAccount(account);
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}
	
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
