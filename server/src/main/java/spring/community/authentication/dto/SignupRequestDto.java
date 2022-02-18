package spring.community.authentication.dto;

import lombok.Data;
import spring.community.user.dto.UserDto;
import spring.community.user.entity.User;

import javax.validation.constraints.*;

@Data
public class SignupRequestDto {

  @Pattern(
    regexp = "(^\\D)(\\w|[가-힣]){2,12}",
    message = "사용자 이름 형식이 맞지 않습니다."
  )
  private String username;

  @Pattern(
    regexp = "^([!@#$%&])([A-Z])([a-z]{2,3})([a-z0-9]{4,10})",
    message = "비밀번호 형식이 맞지 않습니다."
  )
  private String password;

  @Email(message = "이메일 형식이 아닙니다.")
  private String email;

  public User toUserEntity() {
    return UserDto.builder()
      .setName(username)
      .setPassword(password)
      .setEmail(email)
      .build()
      .toEntity();
  }

  @Override
  public String toString() {
    return "SignUpDto{" +
      "username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", email='" + email + '\'' +
      '}';
  }

}
