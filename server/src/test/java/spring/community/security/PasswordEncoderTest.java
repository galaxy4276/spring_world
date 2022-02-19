package spring.community.security;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.community.authentication.dto.SignupRequestDto;
import spring.community.user.entity.User;
import spring.community.user.repository.dao.UserRepository;
import spring.community.user.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PasswordEncoderTest {

  @Mock
  UserRepository userRepository;
  @Mock
  PasswordEncoder passwordEncoder;

  @InjectMocks
  UserServiceImpl userService;

  final PasswordEncoder localPasswordEncoder = new BCryptPasswordEncoder();
  String plainPassword = "@Umjunsik123";

  @Test
  @DisplayName("평문 값 암호화 테스트")
  void passwordEncode() {

    // given
    String password = "@howPeopleNameIsUmJunSik12";

    // when
    String encodedPassword = localPasswordEncoder.encode(password);

    // then
    assertAll(
      () -> assertNotEquals(password, encodedPassword),
      () -> assertTrue(localPasswordEncoder.matches(password, encodedPassword))
    );
  }

  @Test
  @DisplayName("회원가입한 유저 비밀번호가 암호화된다.")
  void encodeUserPassword() {
    // given
    SignupRequestDto dto = getMockSignupRequestDto();
    User userFromDto = dto.toUserEntity();
    given(userRepository.save(any(User.class))).willReturn(userFromDto);

    // when
    User user = userService.createUserByRequestDto(dto);

    // then
    assertThat(user).isInstanceOf(User.class);
    assertTrue(localPasswordEncoder.matches(
      plainPassword,
      user.getPassword()
    ));
  }

  private SignupRequestDto getMockSignupRequestDto() {
    SignupRequestDto dto = SignupRequestDto.builder()
      .username("엄준식")
      .password(plainPassword)
      .email("umjunsik@ishowpeople.name")
      .build();
    dto.setPassword(localPasswordEncoder.encode(dto.getPassword()));
    return dto;
  }

}
