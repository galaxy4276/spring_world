package spring.community.authentication.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;

@Data
@ToString
public class UserVerifiedRequestDto {
  @Email(message = "이메일 형식이 아닙니다.")
  private String email;
}
