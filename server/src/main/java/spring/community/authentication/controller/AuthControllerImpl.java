package spring.community.authentication.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.community.authentication.dto.SignupRequestDto;
import spring.community.authentication.service.AuthServiceImpl;
import javax.validation.Valid;


@Tag(name = "인증 API", description = "사용자 인증을 수행합니다.")
@RestController
@Slf4j
@RequestMapping("auth")
@AllArgsConstructor
public class AuthControllerImpl implements AuthController {

  private final AuthServiceImpl authService;

  @Override
  @PostMapping("signup")
  @Operation(summary = "회원가입")
  public ResponseEntity<Void> signup(
    final @Valid @RequestBody SignupRequestDto signupRequestDto
  ) {
    authService.signup(signupRequestDto);
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  @Override
  @GetMapping("signup/verification/{token}")
  public ResponseEntity<Void> verifyUser(
    @PathVariable("token") String token,
    @RequestParam(value = "email") String email
  ) {
    authService.verifyUserByToken(token, email);
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  @Override
  public void isCheckUserUrlAuth(String email) {}

  @Override
  public void login() {}

  @Override
  public void sendOneTimePasswordForUser(String email) {}

  @Override
  public void verifyOneTimePassword() {}
}
