package org.mo.jims.coop.repository;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.mo.open.common.entity.UserLog;
import org.mo.open.common.repository.UserLogRepository;
import org.mo.open.common.util.BaseTest;

public class UserLogRepositoryTest extends BaseTest {
	private UserLogRepository userLogRepository;

	public UserLogRepository getUserLogRepository() {
		return userLogRepository;
	}

	@Resource(name = "userLogRepository")
	public void setUserLogRepository(UserLogRepository userLogRepository) {
		this.userLogRepository = userLogRepository;
	}

	private String name;

	@Before
	public void init() {
		name = "moziqi";
	}

	@Test
	public void testCountByAccount() {

	}

	@Test
	public void testSelectByAccount() {
		userLogRepository.selectByAccount("moziqi", 1, 10);
	}

	@Test
	public void testCountByLikeAccount() {

	}

	@Test
	public void testSelectByLikeAccount() {

	}

	@Test
	public void testSelectByPK() {
		UserLog selectByPK = userLogRepository.selectByPK(new Long(1));
		System.out.println(selectByPK.getTime());
	}

	@Test
	public void testInsert() {

	}

	@Test
	public void testUpdateByPK() {

	}

	@Test
	public void testDeleteByPK() {

	}

}
