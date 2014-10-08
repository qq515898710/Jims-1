package org.mo.jims.coop.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mo.open.common.entity.UserLog;
import org.mo.open.common.service.UserLogService;
import org.mo.open.common.util.BaseTest;
import org.mo.open.common.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserLogServiceTest extends BaseTest {
	@Autowired
	private UserLogService userLogService;
	private String name;
	private int page;
	private int pageSize;

	@Before
	public void init() {
		name = "mo";
		page = 1;
		pageSize = 10;
	}

	@Test
	public void testGetUserLogByAccount() {
		Page<UserLog> userLogByAccount = userLogService.getUserLogByAccount(name,
				page, pageSize);
		Assert.notNull(userLogByAccount, "userLogByAccount不为null");
		List<UserLog> content = userLogByAccount.getContent();
		for(int i=0;i<content.size();i++){
			UserLog tbUserLog = content.get(i);
//			System.out.println(tbUserLog.getId()+"--"+tbUserLog.getTime()+"--"+tbUserLog.getTbUser().getAccount());
		}
	}

	@Test
	public void testGetUserLogByLikeAccount() {
		Page<UserLog> userLogByAccount = userLogService.getUserLogByLikeAccount(name,
				page, pageSize);
		Assert.notNull(userLogByAccount, "userLogByAccount不为null");
		List<UserLog> content = userLogByAccount.getContent();
		for(int i=0;i<content.size();i++){
			UserLog tbUserLog = content.get(i);
//			System.out.println(tbUserLog.getId()+"--"+tbUserLog.getTime()+"--"+tbUserLog.getTbUser().getAccount());
		}
	}

	@Test
	public void testGetByPK() {
	}

	@Test
	public void testSave() {
	}

	@Test
	public void testAlter() {
	}

	@Test
	public void testRemoveByPK() {
	}

}
