package org.mo.open.common.service;


import java.util.List;

import org.junit.Test;
import org.mo.open.common.entity.User;
import org.mo.open.common.util.BaseTest;
import org.mo.open.common.util.Page;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseTest{

	@Autowired
	private UserService userService;
	
	@Test
	public void testCheckLogin() {
		
	}

	@Test
	public void testGetALLUserInfo() {
		User user2 = new User();
		Page<User> allUserInfo = userService.getALLUserInfo(user2 , 1, 1000);
		List<User> content = allUserInfo.getContent();
		for(User user :content){
			System.out.println(user.toString());
		}
	}

	@Test
	public void testGetUserByPK() {
		
	}

	@Test
	public void testSaveUser() {
//		User entity = new User("66666662", "123456");
//		boolean saveUser = userService.saveUser(entity);
//		if(saveUser){
//			System.out.println("保存成功");
//		}else{
//			System.out.println("保存失败");
//		}
	}

	@Test
	public void testAlterUser() {
		
	}

	@Test
	public void testRemoveUserByPK() {
		
	}

}
