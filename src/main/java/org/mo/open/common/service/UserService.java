package org.mo.open.common.service;

import java.util.List;

import javax.annotation.Resource;

import org.mo.open.common.entity.Role;
import org.mo.open.common.entity.User;
import org.mo.open.common.entity.UserRole;
import org.mo.open.common.repository.RoleRepository;
import org.mo.open.common.repository.UserRepository;
import org.mo.open.common.util.ManageProperties;
import org.mo.open.common.util.Page;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

	private UserRepository userRepository;
	
	private RoleRepository roleRepository;
	
	private Md5PasswordEncoder md5PasswordEncoder;
	
	private final static int BATCH_SIZE = 100;
	
	private final String SALT = "/%El-B9ua* vbo@N#,WU[+Mp+c-5#zgP&1w^-I*#|r]i`HdQ7eMTA$UCFXnA]2xR";

	public boolean checkLogin(User user){
		User login = null;
		login = userRepository.selectUserByAccountAndPassword(user.getAccount(), user.getPassword());
		if (login != null) {
			return true;
		}
		return false;
	}
	
	public boolean removeUserRoleRelativity(UserRole userRole){
		userRepository.deleteRelativity(userRole);
		return true;
	}
	
	public boolean existAccount(String account){
		int countUserByAccount = userRepository.countUserByAccount(account);
		if(countUserByAccount > 0){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean existUsername(String username){
		int countUserByUsername = userRepository.countUserByUsername(username);
		if(countUserByUsername > 0){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 分页显示用户信息, 从1算起
	 * 
	 * @param page
	 * @param pageSize
	 * @return
	 */
	
	public Page<User> getALLUserInfo(User user, int page, int pageSize) {
		Page<User> userPage = new Page<User>();
		userPage.setCurrentPage(page);
		userPage.setPageSize(pageSize);
		userPage.setTotalElement(
				userRepository.countAllByCriteria(user.getAccount(), user.getUsername()),
				pageSize);
		if (userPage.getTotalElement() == 0) {
			return userPage;
		}
		List<User> selectAll = userRepository.selectAllByCriteria(user.getAccount(),
				user.getUsername(), (page - 1) * pageSize, pageSize);
		for(User result :selectAll){
			List<Role> selectByUser = roleRepository.selectByUser(result.getAccount());
			result.setRole(selectByUser);
		}
		userPage.setContent(selectAll);
		return userPage;
	}


	/**
	 * 获取用户名
	 * 
	 * @param name
	 * @return
	 */
	
	public User getUserByPK(String account) {
		User user = null;
		user = userRepository.selectByPK(account);
		return user;
	}

	/**
	 * 保存用户信息,返回true保存成功,返回false用户名存在保存失败
	 * 
	 * @param entity
	 * @return
	 */
	
	public boolean saveUser(User entity) {
		int countUserByAccount = userRepository.countUserByAccount(entity.getAccount());
		if(countUserByAccount > 0){
			return false;
		}
		int countUserByUsername = userRepository.countUserByUsername(entity.getUsername());
		if(countUserByUsername > 0){
			return false;
		}
		String content = ManageProperties.getInstance().getContent("SALT");
		if (content == null) {
			content = SALT;
		}
		String encodePassword = md5PasswordEncoder.encodePassword(entity.getPassword(), content);
		entity.setPassword(encodePassword);
		entity.setCreateDate(userRepository.getCurrentTime());
		entity.setLatestDate(userRepository.getCurrentTime());
		try{
			userRepository.insert(entity);
		}catch(Exception exception){
			System.err.println("保存用户信息失败");
			return false;
		}
		List<Role> role2 = entity.getRole();
		if (role2 != null) {
			for (Role role : role2) {
				UserRole userRole = new UserRole();
				userRole.setUser(entity);
				userRole.setRole(role);
				roleRepository.saveRelativity(userRole);
			}
		} else if(role2 == null || role2.size() == 1){
			UserRole userRole = new UserRole();
			userRole.setUser(entity);
			Role role = roleRepository.selectByName("user");
			userRole.setRole(role);
		}
		return true;
	}

	/**
	 * 修改用户信息
	 * 
	 * @param tbUser
	 */
	
	public boolean alterUser(User entity) {
		if (entity != null) {
			String content = ManageProperties.getInstance().getContent("SALT");
			if (content == null) {
				content = SALT;
			}
			String encodePassword = md5PasswordEncoder.encodePassword(entity.getPassword(), content);
			entity.setPassword(encodePassword);
			userRepository.updateByPK(entity);
			return true;
		}
		return false;
	}

	
	public boolean removeUserByPK(String id) {
		userRepository.deleteByPK(id);
		return true;
	}
	
	public boolean batchRemove(List<String> id){
		if (id.size() > 0) {
			if (id.size() <= BATCH_SIZE) {
				userRepository.batchDelete(id);
			} else {
				int count = id.size() / BATCH_SIZE;
				if (id.size() % BATCH_SIZE != 0) {
					count += 1;
				}
				List<String> temp = null;
				int startIndex = 0;
				int endIndex = 0;
				for (int i = 0; i < count; i++) {
					startIndex = i * BATCH_SIZE;
					endIndex = startIndex + BATCH_SIZE;
					if (endIndex > id.size()) {
						endIndex = id.size();
					}
					System.out.println("=========== 批次：" + (i + 1)
							+ ", startIndex:" + startIndex + ", endIndex:"
							+ endIndex);
					temp= id.subList(startIndex, endIndex);
					userRepository.batchDelete(temp);
				}
			}
			return true;
		}
		return false;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	@Resource(name = "userRepository")
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Md5PasswordEncoder getMd5PasswordEncoder() {
		return md5PasswordEncoder;
	}
	
	@Resource(name = "md5PasswordEncoder")
	public void setMd5PasswordEncoder(Md5PasswordEncoder md5PasswordEncoder) {
		this.md5PasswordEncoder = md5PasswordEncoder;
	}
	
	public RoleRepository getRoleRepository() {
		return roleRepository;
	}
	
	@Resource(name = "roleRepository")
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

}
