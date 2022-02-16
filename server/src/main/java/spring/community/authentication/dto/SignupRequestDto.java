package spring.community.authentication.dto;

import lombok.Data;
import spring.community.user.dto.UserDto;
import spring.community.user.entity.User;

import javax.validation.constraints.*;

@Data
public class SignupRequestDto {

//  @Min(3)
//  @Max(13)
  @NotBlank(message = "사용자 이름은 빈 값일 수 없습니다.")
  @Pattern(regexp = "(^\\D)(\\w|[가-힣]){2,12}", message = "사용자 이름 형식이 맞지 않습니다.")
  private String username;  // (^\D)(\w|[가-힣]){2,12}

  @NotBlank(message = "비밀번호는 빈 값일 수 없습니다.")
  private String password; // ^([!@#$%&])([A-Z]{1,1})[a-z]{6,15}

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
