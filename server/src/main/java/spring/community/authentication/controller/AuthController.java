package spring.community.authentication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import spring.community.authentication.dto.SignupRequestDto;
import spring.community.authentication.dto.UserVerifiedRequestDto;
import spring.community.authentication.dto.UserVerifiedResponseDto;
import spring.community.helper.annotation.Draft;

@Draft(progress = "메서드 이름만 정의")
public interface AuthController {

  // 사용자 회원가입을 수행합니다.
  ResponseEntity<Void> signup(SignupRequestDto signupDto);

  // 토큰 데이터 기반으로 사용자의 이메일 인증을 수행합니다.
  ResponseEntity<Void> verifyUser(String token, String email);

  // 해당 이메일 사용자가 URL 인증을 수행한 유저인 지 반환합니다.
  ResponseEntity<UserVerifiedResponseDto> isCheckUserUrlAuth(UserVerifiedRequestDto email);

  // 사용자 로그인을 수행합니다.
  void login();

  // 비밀번호 초기화용 패스워드를 해당 이메일로 전송합니다.
  void sendOneTimePasswordForUser(String email);

  // 비밀번호 초기화용 패스워드를 검증합니다.
  void verifyOneTimePassword();

}
