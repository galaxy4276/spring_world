package spring.community.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import spring.community.authentication.entity.SignupVerification;
import spring.community.helper.entity.FullTimeStamp;
import spring.community.user.dto.UserDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", length = 12, nullable = false, unique = true)
  private String name;

  @Column(name = "password", length = 64, nullable = false)
  private String password;

  @Column(name = "email", nullable = false)
  private String email;

  @Embedded
  private FullTimeStamp fullTimeStamp;

  public User() { }

  public UserDto toUserDto() {
    return UserDto.builder()
            .id(id)
            .name(name)
            .email(email)
            .password(password)
            .createdAt(fullTimeStamp.getCreatedAt())
            .updatedAt(fullTimeStamp.getUpdatedAt())
            .deletedAt(fullTimeStamp.getDeletedAt())
            .build();
  }

  @OneToMany(mappedBy = "user")
  private final List<UserRole> userRoleList = new ArrayList<>();

  @OneToOne(mappedBy = "user")
  private SignupVerification signupVerification;

}
