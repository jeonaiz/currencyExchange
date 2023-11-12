package services;

import models.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    Role updateRole(Role role);
    void deleteRole(Long roleId);
    Role getRoleById(Long roleId);
    List<Role> getAllRoles();
}

