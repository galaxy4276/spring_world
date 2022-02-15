package spring.community.authentication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import spring.community.authentication.dto.SignupVerificationDto;
import spring.community.helper.CommonBuilder;
import spring.community.helper.entity.CreateTimeStamp;
import spring.community.user.entity.User;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@AllArgsConstructor
@Table(name = "signup_verification")
public class SignupVerification {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String token;

  @OneToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Embedded
  private CreateTimeStamp createTimeStamp;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "expired_at")
  private Date expiredAt;

  @Column(name = "is_verified", columnDefinition = "boolean default false")
  private boolean isVerified;

  public SignupVerificationDto toSignupVerificationDto() {
    return SignupVerificationDto.builder()
      .id(id)
      .token(token)
      .user(user)
      .expiredAt(expiredAt)
      .isVerified(isVerified)
      .createdAt(createTimeStamp.getCreatedAt())
      .build();
  }

  private SignupVerification(SVBuilder builder) {
    this.id = builder.id;
    this.user = builder.user;
    this.token = builder.token;
    this.isVerified = builder.isVerified;
    this.createTimeStamp = builder.createTimeStamp;
    this.expiredAt = builder.expiredAt;
  }

  public static class SVBuilder implements CommonBuilder<SignupVerification> {
    private final Long id;
    private final String token;
    private final User user;
    private final Date expiredAt;
    private final boolean isVerified;
    private final CreateTimeStamp createTimeStamp;

    public SVBuilder(SignupVerificationDto signupVerificationDto) {
      CreateTimeStamp createTimeStamp = new CreateTimeStamp();
      createTimeStamp.setCreatedAt(signupVerificationDto.getCreatedAt());
      this.id = signupVerificationDto.getId();
      this.token = signupVerificationDto.getToken();
      this.user = signupVerificationDto.getUser();
      this.createTimeStamp =createTimeStamp;
      this.expiredAt = signupVerificationDto.getExpiredAt();
      this.isVerified = signupVerificationDto.isVerified();
    }

    @Override
    public SignupVerification build() {
      return new SignupVerification(this);
    }
  }

}
