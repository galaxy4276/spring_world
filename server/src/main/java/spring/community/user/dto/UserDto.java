package spring.community.user.dto;

import lombok.*;
import spring.community.user.entity.User;

import java.util.Date;

@Data
@NoArgsConstructor
@ToString
public class UserDto {
  private Long id;
  private String name;
  private String password;
  private String email;
  private Date createdAt;
  private Date updatedAt;
  private Date deletedAt;

  @Builder
  public UserDto(Long id, String name, String password, String email, Date createdAt, Date updatedAt, Date deletedAt) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.email = email;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }

  public User toEntity() {
    return User.builder()
            .id(id)
            .email(email)
            .name(name)
            .password(password)
            .createdAt(createdAt)
            .updatedAt(updatedAt)
            .deletedAt(deletedAt)
            .build();
  }

}
