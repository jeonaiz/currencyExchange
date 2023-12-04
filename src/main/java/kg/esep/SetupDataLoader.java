//package kg.esep;
//
//import jakarta.transaction.Transactional;
//import kg.esep.dao.PrivilegeRepository;
//import kg.esep.dao.RoleRepository;
//import kg.esep.dao.UserRepository;
//import kg.esep.models.Privilege;
//import kg.esep.models.Role;
//import kg.esep.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//
//@Component
//public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
//
//    boolean alreadySetup = false;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private PrivilegeRepository privilegeRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    @Transactional
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//
//        if (alreadySetup)
//            return;
//        Privilege readPrivilege
//                = createPrivilegeIfNotFound("READ_PRIVILEGE");
//        Privilege writePrivilege
//                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
//
//        List<Privilege> adminPrivileges = Arrays.asList(
//                readPrivilege, writePrivilege);
//        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
//        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));
//
//        Role adminRole = roleRepository.findByRoleName("ROLE_ADMIN");
//        User user = new User();
//        user.setFirstName("Test");
//        user.setLastName("Test");
//        user.setPassword(passwordEncoder.encode("test"));
//        user.setEmail("test@test.com");
//        user.setRoles(Arrays.asList(adminRole));
//        user.setEnabled(true);
//        userRepository.save(user);
//
//        alreadySetup = true;
//    }
//
//
//    @Transactional
//    public Privilege createPrivilegeIfNotFound(String name) {
//
//        Privilege privilege = privilegeRepository.findByName(name);
//        if (privilege == null) {
//            privilege = new Privilege();
//            privilegeRepository.save(privilege);
//        }
//        return privilege;
//    }
//
//    @Transactional
//    public Role createRoleIfNotFound(String roleName, Collection<Privilege> privileges) {
//
//        Role role = roleRepository.findByRoleName(roleName);
//        if (role == null) {
//            role = new Role();
//            role.setPrivileges(privileges);
//            roleRepository.save(role);
//        }
//        return role;
//    }
//}