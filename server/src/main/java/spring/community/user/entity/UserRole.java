package spring.community.user.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import spring.community.helper.entity.FullTimeBaseEntity;

import javax.persistence.*;

@SuperBuilder(setterPrefix = "set")
@Entity
@Getter
@Table(name = "user_roles")
public class UserRole extends FullTimeBaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user", referencedColumnName = "id")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role", referencedColumnName = "id")
  private Role role;

}
