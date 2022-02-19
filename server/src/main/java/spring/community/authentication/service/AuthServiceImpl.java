package spring.community.authentication.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.community.authentication.dto.SignupRequestDto;
import spring.community.authentication.entity.SignupVerification;
import spring.community.authentication.exception.AlreadyExistsUserException;
import spring.community.authentication.service.interfaces.AuthDataHelpService;
import spring.community.authentication.service.interfaces.AuthService;
import spring.community.authentication.service.interfaces.GenerateAuthKeyService;
import spring.community.mail.MailService;
import spring.community.user.entity.User;
import spring.community.user.repository.dao.UserRepository;
import spring.community.user.service.interfaces.UserService;

/**
 * @desc 인증의 메인 기능이 구현됩니다.
 */
@Service
@AllArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

  private final AuthDataHelpService authDataHelpService;
  private final UserRepository userRepository;
  private final MailService mailService;
  private final UserService userService;
  private final GenerateAuthKeyService generateAuthKeyService;

  @Override
  public void signup(SignupRequestDto signupRequestDto) {
    User user =
      userRepository.findByEmail(signupRequestDto.getEmail())
          .orElseGet(() -> userService.createUserByRequestDto(signupRequestDto));
    sendSignupVerificationUrl(user);
  }

  @Override
  public void sendSignupVerificationUrl(User user) {
    SignupVerification signupVerification = authDataHelpService
      .findOrCreateSVByUser(user);
    String newToken = generateAuthKeyService.GenerateSignupToken();
      if (signupVerification.isVerified())
          throw new AlreadyExistsUserException(user.getEmail());
      mailService.
        sendUserJoinVerificationMail(newToken, user.getName(), user.getEmail());
  }

}
