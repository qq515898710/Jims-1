package org.mo.open.common.entity;

/**
 * 角色与权限关联表
 * 
 * @author moziqi
 *
 */
public class RolePermission implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Role role;
	
	private Permission permission;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

}
