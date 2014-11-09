package org.mo.open.common.repository;

import org.junit.Test;
import org.mo.open.common.entity.Permission;
import org.mo.open.common.util.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

public class PermissionRepositoryTest extends BaseTest {

	@Autowired
	private PermissionRepository permissionRepository;

	@Test
	public void testCount() {

	}

	@Test
	public void testSelectAll() {

	}

	@Test
	public void testGetPermissions() {

	}

	@Test
	public void testSelectByPK() {

	}

	@Test
	public void testInsert() {
		/**
		 * 测试获取立刻插入的数据库的id
		 */
		Permission entity = new Permission("游客2", "未授权的用户");
		int insert = permissionRepository.insert(entity);
		System.out.println(entity.getId());//获取到的即为新插入记录的ID
	}

	@Test
	public void testUpdateByPK() {

	}

	@Test
	public void testDeleteByPK() {

	}

}
