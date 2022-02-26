package spring.community.user.service.interfaces;

import spring.community.authentication.dto.SignupRequestDto;
import spring.community.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

  public Optional<User> findById(Long id);

  public List<User> findAll();

}
