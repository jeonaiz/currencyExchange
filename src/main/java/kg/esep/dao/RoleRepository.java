package kg.esep.dao;

import kg.esep.models.Role;
import kg.esep.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {

    Role findByName(String name);
}
