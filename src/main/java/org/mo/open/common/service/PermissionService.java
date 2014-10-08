package org.mo.open.common.service;

import java.util.List;

import javax.annotation.Resource;

import org.mo.open.common.entity.Permission;
import org.mo.open.common.repository.PermissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service( "permissionService")
public class PermissionService  {
	private PermissionRepository permissionRepository;

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Permission> gettAll() {
		return permissionRepository.selectAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Permission getByPK(Long id) {
		return permissionRepository.selectByPK(id);
	}

	@Transactional(noRollbackFor = Exception.class)
	public boolean save(Permission entity) {
		permissionRepository.insert(entity);
		return true;
	}

	@Transactional(noRollbackFor = Exception.class)
	public boolean alter(Permission entity) {
		permissionRepository.updateByPK(entity);
		return true;
	}

	@Transactional(noRollbackFor = Exception.class)
	public boolean removeByPK(Long id) {
		permissionRepository.deleteByPK(id);
		return true;
	}

	public PermissionRepository getPermissionRepository() {
		return permissionRepository;
	}

	@Resource(name = "permissionRepository")
	public void setPermissionRepository(PermissionRepository permissionRepository) {
		this.permissionRepository = permissionRepository;
	}
}
