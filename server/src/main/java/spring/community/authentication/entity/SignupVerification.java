package spring.community.authentication.entity;

import spring.community.helper.entity.CreateTimeStamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "signup_verification")
public class SignupVerification {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 255, nullable = false)
  private String token;

  @Column(name = "email", nullable = false)
  private String email;

  @Embedded
  private CreateTimeStamp createTimeStamp;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "expired_at")
  private Date expiredAt;

  @Column(name = "is_verified", columnDefinition = "boolean default false")
  private boolean isVerified;

}
