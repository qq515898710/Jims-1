package org.mo.open.common.security;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mo.open.common.entity.User;
import org.mo.open.common.entity.UserLog;
import org.mo.open.common.service.UserLogService;
import org.mo.open.common.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * 处理管理员日志
 * 
 * @author moziqi
 *
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private UserLogService userLogService;

	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();
		User user = userService.getUserByPK(username);
		UserLog userLog = new UserLog(user);
		System.out.println(user.toString()+"-------------------------------------------LoginSuccessHandler");
		userLogService.saveUserLog(userLog);
		userService.alterUser(user);
		super.onAuthenticationSuccess(request, response, authentication);
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserLogService getUserLogService() {
		return userLogService;
	}

	@Resource(name = "userLogService")
	public void setUserLogService(UserLogService userLogService) {
		this.userLogService = userLogService;
	}

}
