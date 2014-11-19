package org.mo.open.common.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mo.open.common.entity.User;
import org.mo.open.common.entity.UserLog;
import org.mo.open.common.repository.UserLogRepository;
import org.mo.open.common.repository.UserRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserService {

	private UserRepository userRepository;
	private UserLogRepository userLogRepository;

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
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
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
	 * 保存用户登录日志信息
	 * 
	 * @param user
	 */
	@Transactional(rollbackFor = Exception.class)
	private void saveUserLoginLog(User user) {
		UserLog entity = new UserLog();
		entity.setUser(user);
		entity.setLoginTime(new Date(System.currentTimeMillis()));
		userLogRepository.insert(entity);
	}

	/**
	 * 获取用户名
	 * 
	 * @param name
	 * @return
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public User getByPK(String account) {
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
	@Transactional(rollbackFor = Exception.class)
	public boolean save(User entity) {
		User userByAccount = this.getByPK(entity.getAccount());
		if (userByAccount != null) {
			return false;
		}
		userRepository.insert(entity);
		this.saveUserLoginLog(entity);
		return true;
	}

	/**
	 * 修改用户信息
	 * 
	 * @param tbUser
	 */
	@Transactional(rollbackFor = Exception.class)
	public boolean alter(User entity) {
		userRepository.updateByPK(entity);
		return true;
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean removeByPK(String id) {
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

	public UserLogRepository getUserLogRepository() {
		return userLogRepository;
	}

	@Resource(name = "userLogRepository")
	public void setUserLogRepository(UserLogRepository userLogRepository) {
		this.userLogRepository = userLogRepository;
	}

}
