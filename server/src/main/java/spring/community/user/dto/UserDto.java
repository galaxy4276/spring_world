package spring.community.user.dto;

import lombok.*;
import spring.community.user.entity.User;

import java.time.LocalDateTime;

@Data
@ToString
@Builder(setterPrefix = "set")
public class UserDto {
  private Long id;
  private String name;
  private String password;
  private String email;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;


  public User toEntity() {
    return User.builder()
      .setId(id)
      .setName(name)
      .setPassword(password)
      .setEmail(email)
      .setCreatedAt(createdAt)
      .setUpdatedAt(updatedAt)
      .setDeletedAt(deletedAt)
      .build();
  }

}
