package org.mo.open.common.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.mo.open.common.entity.Permission;
import org.mo.open.common.entity.Role;
import org.mo.open.common.exception.MyRuntimeException;
import org.mo.open.common.repository.PermissionRepository;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;

@Service("permissionService")
public class PermissionService {

	private PermissionRepository permissionRepository;

	public HashMap<String, Collection<ConfigAttribute>> loadResourceDefine() {
		HashMap<String, Collection<ConfigAttribute>> map = null;
		map = Maps.newHashMap();
		List<Permission> gettAll = this.getPermissionAll();
		System.out.println(gettAll.size());
		if (gettAll != null) {
			for (Permission permission : gettAll) {
				Collection<ConfigAttribute> array = new ArrayList<ConfigAttribute>(
						gettAll.size());
				Iterator<Role> iterator = permission.getRoles().iterator();
				while (iterator.hasNext()) {
					Role next = iterator.next();
					ConfigAttribute configAttribute = new SecurityConfig(
							next.getName());
					array.add(configAttribute);
				}
				map.put(permission.getName(), array);
			}
		}
		return map;
	}

	public List<Permission> getPermissionAll() {
		return permissionRepository.selectAll();
	}

	public Permission getPermissionByPK(Long id) {
		return permissionRepository.selectByPK(id);
	}

	public boolean savePermission(Permission entity) throws Exception {
		if (entity == null) {
			return false;
		}
		permissionRepository.insert(entity);
		return true;
	}

	public boolean alterPermission(Permission entity) {
		if (entity == null) {
			return false;
		}
		permissionRepository.updateByPK(entity);
		return true;
	}

	public boolean removePermissionByPK(Long id) throws RuntimeException {
		try {
			if (id != null && !"".equals(id)) {
				permissionRepository.deleteByPK(id);
			}
			return true;
		} catch (Exception e) {
			throw new MyRuntimeException("删除失败");
		}
	}

	public PermissionRepository getPermissionRepository() {
		return permissionRepository;
	}

	@Resource(name = "permissionRepository")
	public void setPermissionRepository(PermissionRepository permissionRepository) {
		this.permissionRepository = permissionRepository;
	}
}
