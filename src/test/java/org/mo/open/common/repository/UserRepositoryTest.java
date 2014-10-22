package org.mo.open.common.repository;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;

	@Test
	public void testGetCurrentTime() {
		Date currentTime = userRepository.getCurrentTime();
		//System.out.println(currentTime);
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

	}

	@Test
	public void testUpdateByPK() {

	}

	@Test
	public void testDeleteByPK() {

	}

}
