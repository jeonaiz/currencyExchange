package kg.esep.dao;

import kg.esep.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {

    Role findByRoleName(String roleName);


}
