package org.mo.open.common.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mo.open.common.entity.Role;
import org.mo.open.common.entity.UserLog;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends BaseRepository<Role, Long> {
	
	public List<Role> getUserRole(@Param("account")String account);

	public List<UserLog> selectByPage(@Param("offset") int offset, @Param("size") int size);
}
