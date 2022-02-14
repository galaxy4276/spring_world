package spring.community.authentication.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.community.authentication.dto.SignupDto;
import spring.community.authentication.service.AuthService;

import javax.validation.Valid;

@Tag(name = "인증 API", description = "사용자 인증을 수행합니다.")
@RestController
@RequestMapping("/auth")
public class AuthControllerImpl implements AuthController {

  private final AuthService authService;

  public AuthControllerImpl(AuthService authService) {
    this.authService = authService;
  }

  @Override
  @GetMapping("/")
  @Operation(summary = "회원가입")
  public ResponseEntity<Void> signup(@RequestBody @Valid SignupDto signupDto) {
    return new ResponseEntity<Void>(HttpStatus.OK);
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
