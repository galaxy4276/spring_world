package spring.community.authentication.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class SignupDto {

  @Min(3)
  @Max(13)
  @NotBlank(message = "사용자 이름은 빈 값일 수 없습니다.")
  @Pattern(regexp = "(^\\D)(\\w|[가-힣]){2,12}")
  private String username;  // (^\D)(\w|[가-힣]){2,12}

  @NotBlank(message = "비밀번호는 빈 값일 수 없습니다.")
  private String password; // ^([!@#$%&])([A-Z]{1,1})[a-z]{6,15}

  @Email(message = "이메일 형식이 아닙니다.")
  private String email;

  @Override
  public String toString() {
    return "SignUpDto{" +
      "username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", email='" + email + '\'' +
      '}';
  }
}
