package org.mo.open.common.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mo.open.common.entity.Permission;
import org.mo.open.common.entity.RolePermission;
import org.springframework.stereotype.Repository;

@Repository("permissionRepository")
public interface PermissionRepository extends BaseRepository<Permission, Long> {

	public List<Permission> getPermissions(String account);

	public List<Permission> selectByRole(String roleName);
	
	public void saveRelativity(RolePermission rolePermission);
	
	public List<Permission> selectByPage(@Param("offset") int offset,
			@Param("size") int size);

}
