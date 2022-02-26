package spring.community.user.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.community.user.entity.User;
import spring.community.user.repository.dao.UserRepository;
import spring.community.user.service.interfaces.UserService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Deprecated
  public Optional<User> findById(Long id) {
    return userRepository.findById(id);
  }

  @Deprecated
  public List<User> findAll() {
     return userRepository.findAll();
  }

}
