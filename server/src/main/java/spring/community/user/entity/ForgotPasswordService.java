package spring.community.user.entity;

import lombok.*;
import spring.community.helper.entity.CreateTimeStamp;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "forgot_password_service")
public class ForgotPasswordService {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "one_time_pw", length = 36, nullable = false)
  private String oneTimePassword;

  @Column(name = "is_success_change", nullable = false,
          columnDefinition = "boolean default false")
  private boolean isSuccessChange;

  @Embedded
  private CreateTimeStamp createTimeStamp;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user", referencedColumnName = "id")
  private User user;
}
