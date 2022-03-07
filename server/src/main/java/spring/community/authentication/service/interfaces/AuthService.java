package spring.community.authentication.service.interfaces;

import spring.community.authentication.dto.SignupRequestDto;
import spring.community.authentication.entity.SignupVerification;
import spring.community.helper.annotation.Draft;
import spring.community.user.entity.User;

@Draft(progress = "signup 기능만 정의")
public interface AuthService {

  // 사용자 회원가입 요청 데이터로 사용자 회원가입을 수행합니다.
  void signup(SignupRequestDto signupRequestDto);

  // 사용자에게 회원가입 이메일 url 을 전송합니다.
  void sendSignupVerificationUrl(SignupVerification signupVerification, User user);

  // 사용자의 인증 여부를 반환합니다. ( boolean )
  boolean getUserVerifiedAt(String email);

  // 토큰 값 기반으로 사용자 인증 처리를 진행합니다.
  void verifyUserByToken(String token, String email);

}
