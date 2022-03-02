package spring.community.security;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class PasswordEncoderTest {

  final PasswordEncoder localPasswordEncoder = new BCryptPasswordEncoder();

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

}
