package org.mo.open.common.service;

import java.util.List;

import javax.annotation.Resource;

import org.mo.open.common.entity.Role;
import org.mo.open.common.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service( "roleService")
public class RoleService  {
	private RoleRepository roleRepository;

	
	public List<Role> getRoleAll() {
		return roleRepository.selectAll();
	}

	
	public Role getRoleByPK(Long id) {
		return roleRepository.selectByPK(id);
	}

	
	public boolean saveRole(Role entity) {
		if (entity == null) {
			return false;
		}
		roleRepository.insert(entity);
		return true;
	}

	
	public boolean alterRole(Role entity) {
		if (entity == null) {
			return false;
		}
		roleRepository.updateByPK(entity);
		return true;
	}

	
	public boolean removeRoleByPK(Long id) {
		roleRepository.deleteByPK(id);
		return true;
	}

	public RoleRepository getRoleRepository() {
		return roleRepository;
	}

	@Resource(name = "roleRepository")
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
}
