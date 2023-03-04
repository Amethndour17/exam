package sn.mouhamadou.mouhamadou.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.mouhamadou.mouhamadou.Entities.User;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String email, String password);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);
}
