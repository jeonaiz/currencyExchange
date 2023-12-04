package kg.esep.services.impl;

import kg.esep.dao.RoleRepository;
import kg.esep.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kg.esep.services.RoleService;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService
{

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role createRole( Role roleName ) {
        return roleRepository.save(roleName);
    }

    @Override
    public Role updateRole(Role roleName) {
        return roleRepository.save(roleName);
    }

    @Override
    public void deleteRole(Long roleId) {
        roleRepository.deleteById(roleId);
    }

    @Override
    public Role getRoleById(Long roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
