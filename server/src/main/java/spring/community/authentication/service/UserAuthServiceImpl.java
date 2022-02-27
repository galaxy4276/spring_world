package spring.community.authentication.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.community.authentication.dto.SignupRequestDto;
import spring.community.authentication.entity.SignupVerification;
import spring.community.authentication.exception.AlreadyExistsUserException;
import spring.community.authentication.exception.AlreadyUserNameException;
import spring.community.authentication.service.interfaces.UserAuthService;
import spring.community.user.entity.User;
import spring.community.user.repository.dao.UserRepository;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public User createUserByDto(SignupRequestDto signupRequestDto) {
    signupRequestDto.setPassword(
      passwordEncoder.encode(signupRequestDto.getPassword())
    );
    return userRepository.save(signupRequestDto.toUserEntity());
  }

  @Override
  public void verifyAlreadyExistsUsernameByDto(SignupRequestDto signupRequestDto) {
    Optional<User> user = userRepository.findByName(signupRequestDto.getUsername());
    if (user.isPresent()) {
      User existUser = user.get();
      boolean isSameEmail = Objects.equals(existUser.getEmail(), signupRequestDto.getEmail());
      if (!isSameEmail) throw new AlreadyUserNameException(existUser.getName());
    }
  }

  @Override
  public void updateUnVerifiedUserInfo(SignupRequestDto signupRequestDto, User user, SignupVerification signupVerification) {
    if (!signupVerification.isVerified()) {
      user.changeName(signupRequestDto.getUsername());
      user.changeEmail(signupRequestDto.getEmail());
      user.changePassword(passwordEncoder.encode(user.getPassword()));
    } else
      throw new AlreadyExistsUserException(user.getEmail());
  }

}
