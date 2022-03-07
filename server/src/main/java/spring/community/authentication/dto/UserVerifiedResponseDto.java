package spring.community.authentication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class UserVerifiedResponseDto {
  @JsonProperty
  private boolean isVerified;

  public static UserVerifiedResponseDto of(boolean isVerified) {
    UserVerifiedResponseDto dto = new UserVerifiedResponseDto();
    dto.setVerified(isVerified);
    return dto;
  }

  @Override
  public String toString() {
    return "UserVerifiedResponseDto{" +
      "isVerified=" + isVerified +
      '}';
  }

}
