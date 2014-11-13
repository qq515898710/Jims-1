package org.mo.open.common.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mo.open.common.entity.Role;
import org.mo.open.common.entity.RolePermission;
import org.mo.open.common.entity.UserLog;
import org.mo.open.common.entity.UserRole;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends BaseRepository<Role, Long> {

	public List<Role> selectByUser(@Param("account") String account);

	public void deleteRelativity(RolePermission rolePermission);

	public void saveRelativity(UserRole userRole);

	public List<UserLog> selectByPage(@Param("offset") int offset, @Param("size") int size);

}
