package org.mo.open.common.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.mo.open.common.entity.Permission;
import org.mo.open.common.entity.User;
import org.mo.open.common.repository.PermissionRepository;
import org.mo.open.common.repository.UserLogRepository;
import org.mo.open.common.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {
	
	protected static Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

	private PermissionRepository permissionRepository;
	
	
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		try {
			User selcetByAccount = userRepository.selectByPK(account);
			if (selcetByAccount == null) {
				throw new UsernameNotFoundException("该" + account + "不存在");
			}
			userDetails = new Authentication(selcetByAccount,selcetByAccount.getAccount(),
					selcetByAccount.getPassword(), true, true, true, true,grantAuthorities(selcetByAccount));
		} catch (UsernameNotFoundException e) {
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("错误在检索用户");
			throw new UsernameNotFoundException("错误在检索用户");
		}
		return userDetails;
	}
	
	private List<GrantedAuthority> grantAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		List<Permission> permissions = permissionRepository.getPermissions(user.getAccount());
		for (Permission permission : permissions) {
			authorities.add(new SimpleGrantedAuthority(permission.getName()));
		}
		return authorities;
	}

	public PermissionRepository getPermissionRepository() {
		return permissionRepository;
	}

	@Resource(name = "permissionRepository")
	public void setPermissionRepository(PermissionRepository permissionRepository) {
		this.permissionRepository = permissionRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	@Resource(name = "userRepository")
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
