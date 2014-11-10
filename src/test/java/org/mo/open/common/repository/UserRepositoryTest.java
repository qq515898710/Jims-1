package org.mo.open.common.repository;


import java.util.Date;

import org.junit.Test;
import org.mo.open.common.entity.User;
import org.mo.open.common.util.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends BaseTest{
	@Autowired
	private UserRepository userRepository;

	@Test
	public void testGetCurrentTime() {
		Date currentTime = userRepository.getCurrentTime();
		System.out.println(currentTime);
	}
	
	@Test
	public void testGetLatestInsert(){
		User latestInsert = userRepository.getLatestInsert();
		System.out.println(latestInsert.toString());
	}
	
	@Test
	public void testGetLatestInsertId(){
		String latestInsertId = userRepository.getLatestInsertId();
		System.out.println(latestInsertId);
	}
	
	@Test
	public void testCountAll() {

	}

	@Test
	public void testSelectAll() {

	}

	@Test
	public void testSelectUserByAccountAndPassword() {

	}

	@Test
	public void testSelectByPK() {

	}

	@Test
	public void testInsert() {
		User entity = new User("邓小平2", "12345632", new Date());
		int insert = userRepository.insert(entity);
		System.out.println(insert+"----------"+entity.getAccount());
	}

	@Test
	public void testUpdateByPK() {

	}

	@Test
	public void testDeleteByPK() {

	}

}
