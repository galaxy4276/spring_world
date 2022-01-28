package spring.community.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.community.user.entity.User;
import spring.community.user.repository.dao.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public Optional<User> findById(Long id) {
    return userRepository.findById(id);
  }

  public List<User> findAll() {
     return userRepository.findAll();
  }

}
