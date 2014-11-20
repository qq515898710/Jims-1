package org.mo.open.common.service;

import javax.annotation.Resource;

import org.mo.open.common.entity.UserLog;
import org.mo.open.common.repository.UserLogRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;

@Service("userLogService")
public class UserLogService {

	private UserLogRepository userLogRepository;

	/**
	 * 按名字查询分页显示
	 * 
	 * @param account
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Page<UserLog> getUserLogByAccount(String account, int page,
			int pageSize) {
		Page<UserLog> userLogPage = new Page<UserLog>();
		userLogPage.setCurrentPage(page);
		userLogPage.setPageSize(pageSize);
		userLogPage.setTotalElement(userLogRepository.countByAccount(account),
				pageSize);
		if (userLogPage.getTotalElement() == 0) {
			return userLogPage;
		}
		userLogPage.setContent(userLogRepository.selectByAccount(account,
				(page - 1) * pageSize, pageSize));
		return userLogPage;
	}

	/**
	 * 按名字模糊查询分页显示
	 * 
	 * @param account
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Page<UserLog> getUserLogByLikeAccount(String account, int page,
			int pageSize) {
		Page<UserLog> userLogPage = new Page<UserLog>();
		userLogPage.setCurrentPage(page);
		userLogPage.setPageSize(pageSize);
		userLogPage.setTotalElement(
				userLogRepository.countByLikeAccount(account), pageSize);
		if (userLogPage.getTotalElement() == 0) {
			return userLogPage;
		}
		userLogPage.setContent(userLogRepository.selectByLikeAccount(account,
				(page - 1) * pageSize, pageSize));
		return userLogPage;
	}

	public UserLog getUserLogByPK(Long id) {
		return userLogRepository.selectByPK(id);
	}

	public boolean saveUserLog(UserLog entity) {
		if(entity== null){
			return false;
		}
		entity.setLoginTime(userLogRepository.getCurrentTime());
		userLogRepository.insert(entity);
		return true;
	}

	public boolean alterUserLog(UserLog entity) {
		userLogRepository.updateByPK(entity);
		return true;
	}

	public boolean removeUserLogByPK(Long id) {
		userLogRepository.deleteByPK(id);
		return true;
	}

	public UserLogRepository getUserLogRepository() {
		return userLogRepository;
	}

	@Resource(name = "userLogRepository")
	public void setUserLogRepository(UserLogRepository userLogRepository) {
		this.userLogRepository = userLogRepository;
	}

}
