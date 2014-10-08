package org.mo.open.common.repository;

import java.util.List;

import org.mo.open.common.entity.Role;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends BaseRepository<Role, Long> {
	
	public int countAll();
	
	public List<Role> selectAll();
	
}
