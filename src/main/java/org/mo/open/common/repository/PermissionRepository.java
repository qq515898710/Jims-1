package org.mo.open.common.repository;

import java.util.List;

import org.mo.open.common.entity.Permission;
import org.springframework.stereotype.Repository;

@Repository("permissionRepository")
public interface PermissionRepository extends BaseRepository<Permission, Long> {

	public int count();

	public List<Permission> selectAll();

}
