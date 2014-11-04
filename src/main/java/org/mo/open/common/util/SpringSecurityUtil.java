package org.mo.open.common.util;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class SpringSecurityUtil {

	/**
	 * 读取当前用户的信息
	 */
	public static String getUserName() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	/**
	 * 答应security的一些信息
	 */
	public static void printlSecurityInfo() {
		SecurityContext context = SecurityContextHolder.getContext();
		// 登录名
		System.out.println("Username=" + context.getAuthentication().getName());
		// 登录密码，未加密的
		System.out.println("Credentials="
				+ context.getAuthentication().getCredentials());
		WebAuthenticationDetails details = (WebAuthenticationDetails) context
				.getAuthentication().getDetails();
		// 获得访问地址
		System.out.println("RemoteAddress=" + details.getRemoteAddress());
		// 获得sessionid
		System.out.println("SessionId=" + details.getSessionId());
		// 获得当前用户所拥有的权限
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) context
				.getAuthentication().getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			System.out.println("Authority=" + grantedAuthority.getAuthority());
		}
	}
}
