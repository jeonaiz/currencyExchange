package kg.esep;

import jakarta.transaction.Transactional;
import kg.esep.dao.PrivilegeRepository;
import kg.esep.dao.RoleRepository;
import kg.esep.dao.UserRepository;
import kg.esep.models.Privilege;
import kg.esep.models.Role;
import kg.esep.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        Privilege readDatabasePrivilege = createPrivilegeIfNotFound("READ_DATABASE");
        Privilege createUserPrivilege = createPrivilegeIfNotFound("WRITE_USER");


        List<Privilege> adminPrivileges = Arrays.asList(readDatabasePrivilege, createUserPrivilege, readDatabasePrivilege, createUserPrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readDatabasePrivilege));

        Role adminRole = roleRepository.findByRoleName("ROLE_ADMIN");
        Role userRole = roleRepository.findByRoleName("ROLE_USER");

// Админ
        User adminUser = new User();
        adminUser.setAddDate();
        adminUser.setPosition_id(1L);
        adminUser.setFirstName("Admin");
        adminUser.setLastName("Admin");
        adminUser.setPassword(passwordEncoder.encode("admin"));
        adminUser.setEmail("admin@admin.com");
        adminUser.setRoles(Arrays.asList(adminRole));
        adminUser.setEnabled(true);
        adminUser.setPhoneNumber("+996999879491");
        adminUser.setUserName("jeonaiz");
        userRepository.save(adminUser);

// Обычный пользователь
        User regularUser = new User();
        regularUser.setAddDate();
        regularUser.setPosition_id(2L);
        regularUser.setFirstName("User");
        regularUser.setLastName("User");
        regularUser.setPassword(passwordEncoder.encode("user"));
        regularUser.setEmail("user@user.com");
        regularUser.setRoles(Arrays.asList(userRole));
        regularUser.setEnabled(true);
        regularUser.setPhoneNumber("+996999868907");
        regularUser.setUserName("purple");
        userRepository.save(regularUser);

    }
    @Transactional
    public Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege();
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    public Role createRoleIfNotFound(String roleName, Collection<Privilege> privileges) {

        Role role = roleRepository.findByRoleName(roleName);
        if (role == null) {
            role = new Role();
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}