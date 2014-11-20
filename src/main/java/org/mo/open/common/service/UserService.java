package org.mo.open.common.service;

import java.util.List;

import javax.annotation.Resource;

import org.mo.open.common.entity.User;
import org.mo.open.common.repository.UserRepository;
import org.mo.open.common.util.ManageProperties;
import org.mo.open.common.util.Page;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

	private UserRepository userRepository;
	
	private Md5PasswordEncoder md5PasswordEncoder;
	
	private final String SALT = "/%El-B9ua* vbo@N#,WU[+Mp+c-5#zgP&1w^-I*#|r]i`HdQ7eMTA$UCFXnA]2xR";

	public boolean checkLogin(User user){
		User login = null;
		login = userRepository.selectUserByAccountAndPassword(user.getAccount(), user.getPassword());
		if (login != null) {
			return true;
		}
		return false;
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
		User userByAccount = this.getUserByPK(entity.getUsername());
		if (userByAccount != null) {
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
		userRepository.insert(entity);
		return true;
	}

	/**
	 * 修改用户信息
	 * 
	 * @param tbUser
	 */
	
	public boolean alterUser(User entity) {
		if (entity != null) {
			entity.setLatestDate(userRepository.getCurrentTime());
			userRepository.updateByPK(entity);
			return true;
		}
		return false;
	}

	
	public boolean removeUserByPK(String id) {
		userRepository.deleteByPK(id);
		return true;
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

}
