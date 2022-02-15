package spring.community.authentication.service;

import spring.community.authentication.dto.SignupRequestDto;
import spring.community.helper.annotation.Draft;
import spring.community.user.entity.User;

@Draft(progress = "signup 기능만 정의")
public interface AuthService {

  // 사용자 회원가입 요청 데이터로 사용자 회원가입을 수행합니다.
  void signup(SignupRequestDto signupRequestDto) throws Exception;

  // 사용자에게 회원가입 이메일 url 을 전송합니다.
  void sendSignupVerificationUrl(User user);

}
