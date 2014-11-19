package org.mo.open.common.service;

import java.util.List;

import javax.annotation.Resource;

import org.mo.open.common.entity.Role;
import org.mo.open.common.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service( "roleService")
public class RoleService  {
	private RoleRepository roleRepository;

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Role> gettAll() {
		return roleRepository.selectAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Role getByPK(Long id) {
		return roleRepository.selectByPK(id);
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean save(Role entity) {
		roleRepository.insert(entity);
		return true;
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean alter(Role entity) {
		roleRepository.updateByPK(entity);
		return true;
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean removeByPK(Long id) {
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
