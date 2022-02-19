package spring.community.user.service.interfaces;

import spring.community.authentication.dto.SignupRequestDto;
import spring.community.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

  public Optional<User> findById(Long id);

  public List<User> findAll();

  // Dto 로부터 전달된 사용자 객체 정보를 DB에 반영하고 반환합니다.
  public User createUserByRequestDto(SignupRequestDto dto);

}
