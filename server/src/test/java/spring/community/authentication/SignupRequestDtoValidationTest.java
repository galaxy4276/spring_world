package spring.community.authentication;

import static org.assertj.core.api.Assertions.*;
import static spring.community.authentication.dto.SignupRequestError.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.community.authentication.dto.SignupRequestDto;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class SignupRequestDtoValidationTest {

  static ValidatorFactory validatorFactory;
  static Validator validator;

  final String correctUsername = "User12";
  final String correctPassword = "@Testisgood12";
  final String correctEmail = "test12@test.com";

  SignupRequestDto signupRequestDto = SignupRequestDto.builder()
    .username(correctUsername)
    .password(correctPassword)
    .email(correctEmail)
    .build();

  @BeforeAll
  public static void init() {
    validatorFactory = Validation.buildDefaultValidatorFactory();
    validator = validatorFactory.getValidator();
  }

  @DisplayName("닉네임이 2글자 이하일 경우 예외처리 된다.")
  @Test
  void shortUsernameException() {
    // given
    signupRequestDto.setUsername("hi");
    // when
    Set<ConstraintViolation<SignupRequestDto>> violations =
      validator.validate(signupRequestDto);
    // then
    assertErrorMessage(violations, FaultPatternName);
  }

  @DisplayName("패스워드 형식이 맞지 않을 경우 예외처리 된다.")
  @Test
  void faultPasswordException() {
    // given
    signupRequestDto.setPassword("jangbibibi12");
    // when
    Set<ConstraintViolation<SignupRequestDto>> violations =
      validator.validate(signupRequestDto);
    // then
    assertErrorMessage(violations, FaultPatternPassword);
  }

  @DisplayName("이메일 형식이 맞지 않는경우 예외처리 된다.")
  @Test
  void faultEmailException() {
    // given
    signupRequestDto.setEmail("umjunsik!");
    // when
    Set<ConstraintViolation<SignupRequestDto>> violations =
      validator.validate(signupRequestDto);
    // then
    assertErrorMessage(violations, FaultPatternEmail);
  }

  private void assertErrorMessage(
    Set<ConstraintViolation<SignupRequestDto>> violations,
    String message) {
    violations.forEach(e -> {
      assertThat(e.getMessage()).isEqualTo(message);
    });
  }

}
