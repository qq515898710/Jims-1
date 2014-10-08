package org.mo.jims.coop.service;

import java.util.List;

import org.junit.Test;
import org.mo.open.common.service.PermissionService;
import org.mo.open.common.util.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

public class UserPermissionServiceTest extends BaseTest {
	@Autowired
	private PermissionService userPermissionService;

	@Test
	public void testGettAll() {
//		List<UserPermission> gettAll = userPermissionService.gettAll();
//		for(int i=0;i<gettAll.size();i++){
//			UserPermission tbUserPermission = gettAll.get(i);
//			System.out.println(tbUserPermission.getId()+"--"+tbUserPermission.getTbUserRole().getId()+"--"+tbUserPermission.getTbUserRole().getType());
//		}
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
