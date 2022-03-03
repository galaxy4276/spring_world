package spring.community.authentication.dto;

import lombok.Builder;
import lombok.Data;
import spring.community.user.dto.UserDto;
import spring.community.user.entity.User;

import javax.validation.constraints.*;

@Data
@Builder
public class SignupRequestDto {

  @Pattern(
    regexp = "(^\\D)(\\w|[가-힣]){2,12}",
    message = SignupRequestError.FaultPatternName
  )
  private String username;

  @Pattern(
    regexp = "^([!@#$%&])([A-Z])([a-z]{2,3})([a-z0-9]{4,10})",
    message = SignupRequestError.FaultPatternPassword
  )
  private String password;

  @Email(message = SignupRequestError.FaultPatternEmail)
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
