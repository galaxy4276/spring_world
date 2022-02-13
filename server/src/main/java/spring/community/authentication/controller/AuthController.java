package spring.community.authentication.controller;

import spring.community.helper.annotation.Draft;

@Draft(progress = "메서드 이름만 정의")
public interface AuthController {

  // 사용자 회원가입을 수행합니다.
  String signup();

  // 회원가입 진행 중 사용자 인증용 이메일을 발송합니다.
  void sendSignupCodeToEmail(String email);

  // 해당 이메일 사용자가 URL 인증을 수행한 유저인 지 반환합니다.
  void isCheckUserUrlAuth(String email);

  // 사용자 로그인을 수행합니다.
  void login();

  // 비밀번호 초기화용 패스워드를 해당 이메일로 전송합니다.
  void sendOneTimePasswordForUser(String email);

  // 비밀번호 초기화용 패스워드를 검증합니다.
  void verifyOneTimePassword();

}
