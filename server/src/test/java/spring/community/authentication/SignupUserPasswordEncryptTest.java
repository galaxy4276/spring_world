package spring.community.authentication;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.community.authentication.dto.SignupRequestDto;
import spring.community.authentication.service.UserAuthServiceImpl;
import spring.community.user.entity.User;
import spring.community.user.repository.dao.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class SignupUserPasswordEncryptTest {

  @Mock
  UserRepository userRepository;

  @Mock
  PasswordEncoder passwordEncoder;

  @InjectMocks
  UserAuthServiceImpl userAuthService;

  String plainPassword = "@Umjunsik123";
  final PasswordEncoder localPasswordEncoder = new BCryptPasswordEncoder();


  @Test
  @DisplayName("회원가입한 유저 비밀번호가 암호화된다.")
  void encodeUserPassword() {
    // given
    SignupRequestDto dto = getMockSignupRequestDto();
    User userFromDto = dto.toUserEntity();
    given(userRepository.save(any(User.class))).willReturn(userFromDto);

    // when
    User user = userAuthService.createUserByDto(dto);

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
