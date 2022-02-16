package spring.community.authentication.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.community.authentication.dto.SignupRequestDto;
import spring.community.authentication.entity.SignupVerification;
import spring.community.authentication.repository.SignupVerificationRepository;
import spring.community.authentication.service.interfaces.AuthDataHelpService;
import spring.community.authentication.service.interfaces.AuthService;
import spring.community.authentication.service.interfaces.GenerateAuthKeyService;
import spring.community.exception.FaultSetBuilderAttributesException;
import spring.community.mail.MailService;
import spring.community.user.entity.User;
import spring.community.user.repository.dao.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final AuthDataHelpService authDataHelpService;
  private final UserRepository userRepository;
  private final MailService mailService;
  private final SignupVerificationRepository signupVerificationRepository;
  private final GenerateAuthKeyService generateAuthKeyService;

  @Override
  public void signup(SignupRequestDto signupRequestDto) throws FaultSetBuilderAttributesException {
    Optional<User> user =
      userRepository.findByEmail(signupRequestDto.getEmail());
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
    SignupVerification signupVerification = authDataHelpService.findOrCreateSVByUser(user);
    String newToken = generateAuthKeyService.GenerateSignupToken();

      if (signupVerification.isVerified()) {
        System.out.println("이미 인증처리까지 된 유저인데?");
        return; // TODO: 22. 2. 15. 예외 응답 처리
      }

      mailService.
        sendUserJoinVerificationMail(newToken, user.getName(), user.getEmail());
      System.out.println("인증메일 보냈다. 토큰은 " + newToken);
  }

}
