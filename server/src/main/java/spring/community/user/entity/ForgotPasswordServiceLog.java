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
@Table(name = "forgot_password_service_log")
public class ForgotPasswordServiceLog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", insertable = false, updatable = false, nullable = false,
          columnDefinition = "timestamp default CURRENT_TIMESTAMP")
  private Date createdAt;

  @Column(name = "is_success_change", nullable = false,
          columnDefinition = "boolean default false")
  private boolean isSuccessChange;

  @OneToMany(mappedBy = "forgotPasswordServiceLog")
  List<User> users = new ArrayList<>();
}
