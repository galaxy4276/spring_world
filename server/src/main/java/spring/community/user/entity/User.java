package spring.community.user.entity;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import spring.community.authentication.entity.SignupVerification;
import spring.community.helper.entity.FullTimeDate;
import spring.community.user.dto.UserDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@SuperBuilder
@Table(name = "users")
public class User extends FullTimeDate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", length = 12, nullable = false, unique = true)
  private String name;

  @Column(name = "password", length = 64, nullable = false)
  private String password;

  @Column(name = "email", nullable = false)
  private String email;

  public UserDto toUserDto() {
    return UserDto.builder()
            .setId(id)
            .setName(name)
            .setEmail(email)
            .setCreatedAt(createdAt)
            .setUpdatedAt(updatedAt)
            .setDeletedAt(deletedAt)
            .setPassword(password)
            .build();
  }

  @OneToMany(mappedBy = "user")
  private List<UserRole> userRoleList;

  @OneToOne(mappedBy = "user")
  private SignupVerification signupVerification;

}
