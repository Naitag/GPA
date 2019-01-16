package pl.npe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.npe.models.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);

}
