package org.mo.open.common.security;

import javax.annotation.Resource;

import org.mo.open.common.util.ManageProperties;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("myAuthenticationProvider")
public class MyAuthenticationProvider implements AuthenticationProvider {
	
	private UserDetailsService userDetailsService;
	
	private MessageDigestPasswordEncoder passwordEncoder;

	private final String SALT = "/%El-B9ua* vbo@N#,WU[+Mp+c-5#zgP&1w^-I*#|r]i`HdQ7eMTA$UCFXnA]2xR";

	public MyAuthenticationProvider() {
		passwordEncoder = new Md5PasswordEncoder();
	}

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String content = ManageProperties.getInstance().getContent("SALT");
		if (content == null) {
			content = SALT;
		}
		String account = authentication.getName();
		String password = (String) authentication.getCredentials();
		UserDetails user = null;
		try {
			user = userDetailsService.loadUserByUsername(account);
			password = passwordEncoder.encodePassword(password, content);
			if (!password.equals(user.getPassword())) {
				throw new BadCredentialsException("帐号或密码不正确");
			}
		} catch (UsernameNotFoundException e) {
			throw new BadCredentialsException("帐号或密码不正确");
		}

		return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> class1) {
		return true;
	}

	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}
	
	@Resource(name="myUserDetailsService")
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
}
