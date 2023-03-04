package sn.mouhamadou.mouhamadou.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.mouhamadou.mouhamadou.Entities.Role;
import sn.mouhamadou.mouhamadou.Entities.User;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);

}