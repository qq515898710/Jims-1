package org.mo.open.common.security;

import java.util.Collection;

import org.mo.open.common.entity.User;
import org.springframework.security.core.GrantedAuthority;

/**
 * 身份验证
 * 
 * @author moziqi
 *
 */
public class Authentication extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private boolean expired; // 检验是否过期的

	private String latestMessage; // 最新消息
	
	public Authentication(User user, String username, String password,
			boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		this.user = user;
		this.expired =false;
	}

	public User getTbUser() {
		return user;
	}

	public void setTbUser(User tbUser) {
		this.user = tbUser;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public String getLatestMessage() {
		return latestMessage;
	}

	public void setLatestMessage(String latestMessage) {
		this.latestMessage = latestMessage;
	}
	
}
