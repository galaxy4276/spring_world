package spring.community.user.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.community.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  public Optional<User> findById(Long id);

  public Optional<User> findByName(String name);

  public Optional<User> findByEmail(String email);
}
