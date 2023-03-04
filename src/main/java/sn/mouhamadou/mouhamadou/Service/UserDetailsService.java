package sn.mouhamadou.mouhamadou.Service;

import org.springframework.stereotype.Service;
import sn.mouhamadou.mouhamadou.Entities.User;
import sn.mouhamadou.mouhamadou.Repository.UserRepository;

import java.util.List;

@Service
public class UserDetailsService {
    UserRepository repo;
    public List<User> listAll() {
        return repo.findAll();
    }

}
