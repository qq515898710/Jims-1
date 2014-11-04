package org.mo.open.common.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.mo.open.common.entity.Permission;
import org.mo.open.common.entity.Role;
import org.mo.open.common.repository.PermissionRepository;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;

@Service("permissionService")
public class PermissionService {

	private PermissionRepository permissionRepository;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public HashMap<String, Collection<ConfigAttribute>> loadResourceDefine() {
		HashMap<String, Collection<ConfigAttribute>> map = null;
		map = Maps.newHashMap();
		List<Permission> gettAll = this.gettAll();
		System.out.println(gettAll.size());
		if (gettAll != null) {
			for (Permission permission : gettAll) {
				Collection<ConfigAttribute> array = new ArrayList<ConfigAttribute>(gettAll.size());
				Iterator<Role> iterator = permission.getRoles().iterator();
				while(iterator.hasNext()){
					Role next = iterator.next();
					ConfigAttribute configAttribute= new SecurityConfig(next.getName());
					array.add(configAttribute);
				}
				map.put(permission.getName(), array);
			}
		}
		return map;
	}

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
	public void setPermissionRepository(
			PermissionRepository permissionRepository) {
		this.permissionRepository = permissionRepository;
	}
}
