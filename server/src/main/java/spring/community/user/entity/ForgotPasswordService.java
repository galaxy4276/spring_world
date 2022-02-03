package spring.community.user.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "forgot_password_service")
public class ForgotPasswordService {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "one_time_pw", length = 36, nullable = false)
  private String oneTimePassword;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", insertable = false, updatable = false, nullable = false,
          columnDefinition = "timestamp default CURRENT_TIMESTAMP")
  private Date createdAt;

  @Column(name = "is_success_change", nullable = false,
          columnDefinition = "boolean default false")
  private boolean isSuccessChange;

  @OneToMany(mappedBy = "forgotPasswordService")
  List<User> users = new ArrayList<>();
}
