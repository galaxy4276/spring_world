package spring.community.authentication.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.community.authentication.dto.SignupRequestDto;
import spring.community.authentication.entity.SignupVerification;
import spring.community.authentication.exception.AlreadyExistsUserException;
import spring.community.authentication.repository.SignupVerificationRepository;
import spring.community.authentication.service.interfaces.AuthDataHelpService;
import spring.community.authentication.service.interfaces.AuthService;
import spring.community.authentication.service.interfaces.GenerateAuthKeyService;
import spring.community.mail.MailService;
import spring.community.user.entity.User;
import spring.community.user.repository.dao.UserRepository;

import java.util.Optional;

/**
 * @desc 인증의 메인 기능이 구현됩니다.
 */
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final AuthDataHelpService authDataHelpService;
  private final UserRepository userRepository;
  private final MailService mailService;
  private final SignupVerificationRepository signupVerificationRepository;
  private final GenerateAuthKeyService generateAuthKeyService;

  @Override
  public void signup(SignupRequestDto signupRequestDto) {
    Optional<User> user =
      userRepository.findByEmail(signupRequestDto.getEmail());
    System.out.println(user.toString());
    if (user.isPresent()) {
      System.out.println("이미 유저 있는데?");
      sendSignupVerificationUrl(user.get());
    } else {
      User newUser = signupRequestDto.toUserEntity();
      userRepository.save(newUser);
      sendSignupVerificationUrl(newUser);
      System.out.println("새 유저 정보 저장 완료");
    }
  }

  @Override
  public void sendSignupVerificationUrl(User user) {
    SignupVerification signupVerification = authDataHelpService
      .findOrCreateSVByUser(user);
    String newToken = generateAuthKeyService.GenerateSignupToken();
      if (signupVerification.isVerified()) {
        System.out.println("이미 인증처리까지 된 유저인데?");
          throw new AlreadyExistsUserException(user.getEmail());
      }
      mailService.
        sendUserJoinVerificationMail(newToken, user.getName(), user.getEmail());
  }

}
