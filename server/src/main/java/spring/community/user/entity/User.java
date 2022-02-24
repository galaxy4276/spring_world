package spring.community.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import spring.community.authentication.entity.SignupVerification;
import spring.community.helper.entity.FullTimeBaseEntity;
import spring.community.user.dto.UserDto;

import javax.persistence.*;
import java.util.List;

@SuperBuilder(setterPrefix = "set")
@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor
public class User extends FullTimeBaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", length = 12, nullable = false, unique = true)
  private String name;

  @Column(name = "password", length = 64, nullable = false)
  private String password;

  @Column(name = "email", nullable = false, unique = true)
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

  public void changeName(String name) {
    this.name = name;
  }

  public void changeEmail(String email) {
    this.email = email;
  }

  public void changePassword(String password) {
    this.password = password;
  }

}
