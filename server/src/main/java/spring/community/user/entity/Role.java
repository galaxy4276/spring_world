package spring.community.user.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import spring.community.helper.entity.TimeWithoutDeletedBaseEntity;

import javax.persistence.*;
import java.util.List;

@SuperBuilder(setterPrefix = "set")
@Entity
@Getter
@Table(name = "roles")
public class Role extends TimeWithoutDeletedBaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true, length = 5)
  private String name;

  @OneToMany(mappedBy = "role")
  private final List<UserRole> userRoleList;

}
