package spring.community.authentication.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import spring.community.helper.entity.CreateTimeBaseEntity;
import spring.community.user.entity.User;

import javax.persistence.*;

@SuperBuilder(setterPrefix = "set")
@Entity
@Getter
@Table(name = "forgot_password_service_log")
public class ForgotPasswordServiceLog extends CreateTimeBaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "is_success_change", nullable = false,
          columnDefinition = "boolean default false")
  private boolean isSuccessChange;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user", referencedColumnName = "id")
  private User user;
}
