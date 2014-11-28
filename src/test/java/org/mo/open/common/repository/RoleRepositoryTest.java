package org.mo.open.common.repository;


import java.util.List;

import org.junit.Test;
import org.mo.open.common.entity.Role;
import org.mo.open.common.util.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleRepositoryTest extends BaseTest{

	@Autowired
	private RoleRepository roleRepository;
	
	@Test
	public void testSelectByUser() {
		List<Role> selectByUser = roleRepository.selectByUser("moziqi");
		for(Role role :selectByUser){
			System.out.println(role.toString());
		}
	}

	@Test
	public void testDeleteRelativity() {
		
	}

	@Test
	public void testSaveRelativity() {
		
	}

	@Test
	public void testSelectByPage() {
		
	}

}
