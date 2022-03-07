package spring.community.authentication.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import spring.community.authentication.dto.SignupRequestDto;
import spring.community.authentication.entity.SignupVerification;
import spring.community.authentication.exception.AlreadyExistsUserException;
import spring.community.authentication.exception.VerifyCodeExpiredException;
import spring.community.authentication.repository.SignupVerificationRepository;
import spring.community.authentication.service.interfaces.AuthService;
import spring.community.exception.InvalidValueException;
import spring.community.exception.NotFoundTargetException;
import spring.community.mail.MailServiceImpl;
import spring.community.user.entity.User;
import spring.community.user.repository.dao.UserRepository;

import java.time.LocalDateTime;

/**
 * @desc 인증의 메인 기능이 구현됩니다.
 */
@Service
@AllArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

  private final UserAuthServiceImpl userAuthService;
  private final AuthDataHelpServiceImpl authDataHelpService;
  private final UserRepository userRepository;
  private final MailServiceImpl mailService;
  private final GenerateAuthKeyServiceImpl generateAuthKeyService;
  private final BCryptPasswordEncoder encoder;
  private final SignupVerificationRepository signupVerificationRepository;

  @Override
  public void signup(SignupRequestDto signupRequestDto) {
    // 이미 사용 중인 사용자 이름인 지 예외 검사
    userAuthService.verifyAlreadyExistsUsernameByDto(signupRequestDto);

    // 유저, 인증 정보 생성
    User user =
      userRepository.findByEmail(signupRequestDto.getEmail())
          .orElseGet(() -> userAuthService.createUserByDto(signupRequestDto));
    SignupVerification signupVerification =
      authDataHelpService.findOrCreateSVByUser(user);

    // 미 가입된 유저 정보 예외 검사, dto 기반 유저 정보 갱신
    userAuthService.updateUnVerifiedUserInfo(
      signupRequestDto,
      user,
      signupVerification
    );

    // 사용자에게 인증 코드 메일 발송
    sendSignupVerificationUrl(signupVerification, user);
  }

  @Override
  public void sendSignupVerificationUrl(
    SignupVerification signupVerification,
    User user
  ) {
    String newToken = generateAuthKeyService.GenerateSignupToken();
    signupVerification.changeToken(newToken);
      mailService.
        sendUserJoinVerificationMail(newToken, user.getName(), user.getEmail());
  }

  @Override
  public void verifyUserByToken(String token, String email) {
    SignupVerification signupVerification
      = authDataHelpService.getSVByEmailOrThrow(email);
    checkTokenTimeout(signupVerification.getExpiredAt(), email);
    checkEffectiveToken(token, signupVerification.getToken());
    authDataHelpService.verifyingUser(signupVerification);
  }

  @Override
  public boolean getUserVerifiedAt(String email) {
    SignupVerification signupVerification =
      signupVerificationRepository.findByUserEmail(email)
        .orElseThrow(NotFoundTargetException::new);
    return signupVerification.isVerified();
  }

  private void checkTokenTimeout(LocalDateTime expiredAt, String email) {
    LocalDateTime nowTime = LocalDateTime.now();
    if (nowTime.isAfter(expiredAt))
      throw new VerifyCodeExpiredException(email);
  }

  private void checkEffectiveToken(String inputToken, String userToken) {
    if (!encoder.matches(inputToken, userToken))
      throw new InvalidValueException("token", inputToken);
  }

}
