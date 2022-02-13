package spring.community.authentication.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "인증 API", description = "사용자 인증을 수행합니다.")
@RestController
@RequestMapping("/auth")
public class AuthControllerImpl implements AuthController {

  @Override
  @GetMapping("/")
  @Operation(summary = "회원가입")
  public String signup() {
    return "Test";
  }

  @Override
  public void sendSignupCodeToEmail(String email) {}

  @Override
  public void isCheckUserUrlAuth(String email) {}

  @Override
  public void login() {}

  @Override
  public void sendOneTimePasswordForUser(String email) {}

  @Override
  public void verifyOneTimePassword() {}
}
