package org.mo.open.common.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class MyAccessDeniedHandler implements AccessDeniedHandler {

	private static String ACCESS_DENIED_MSG = "message";

	private String accessDeniedUrl;

	public MyAccessDeniedHandler(String accessDeniedUrl) {
		super();
		this.accessDeniedUrl = accessDeniedUrl;
	}

	@Override
	public void handle(HttpServletRequest request,
			HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException,
			ServletException {
		response.sendRedirect(accessDeniedUrl);
		String deniedMessage = accessDeniedException.getMessage();
		String rp = request.getRequestURI();
		request.getSession().setAttribute(ACCESS_DENIED_MSG, deniedMessage);
	}

	public String getAccessDeniedUrl() {
		return accessDeniedUrl;
	}

	public void setAccessDeniedUrl(String accessDeniedUrl) {
		this.accessDeniedUrl = accessDeniedUrl;
	}

}
