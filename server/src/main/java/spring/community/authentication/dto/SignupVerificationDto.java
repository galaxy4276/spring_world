package spring.community.authentication.dto;

import lombok.Builder;
import lombok.Data;
import spring.community.user.entity.User;

import java.util.Date;

@Data
@Builder
public class SignupVerificationDto {
  private Long id;
  private String token;
  private Date createdAt;
  private Date expiredAt;
  private User user;
  private boolean isVerified;

  @Override
  public String toString() {
    return "SignupVerificationDto{" +
      "id=" + id +
      ", token='" + token + '\'' +
      ", createdAt=" + createdAt +
      ", expiredAt=" + expiredAt +
      ", user=" + user +
      ", isVerified=" + isVerified +
      '}';
  }

}
