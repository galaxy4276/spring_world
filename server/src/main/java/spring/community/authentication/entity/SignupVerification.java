package spring.community.authentication.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import spring.community.authentication.dto.SignupVerificationDto;
import spring.community.helper.entity.CreateTimeBaseEntity;
import spring.community.user.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@SuperBuilder(setterPrefix = "set")
@Getter
@Entity
@Table(name = "signup_verification")
@NoArgsConstructor
public class SignupVerification extends CreateTimeBaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String token;

  @OneToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(name = "expired_at")
  private LocalDateTime expiredAt;

  @Column(name = "is_verified", columnDefinition = "boolean default false")
  private boolean isVerified;

  public SignupVerificationDto toSignupVerificationDto() {
    return SignupVerificationDto.builder()
      .setId(id)
      .setToken(token)
      .setUser(user)
      .setExpiredAt(expiredAt)
      .setIsVerified(isVerified)
      .setCreatedAt(createdAt)
      .build();
  }

}
