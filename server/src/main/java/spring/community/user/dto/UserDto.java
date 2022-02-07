package spring.community.user.dto;

import lombok.*;
import spring.community.exception.FaultSetBuilderAttributesException;
import spring.community.user.entity.User;
import spring.community.user.entity.builder.UserBuilder;

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

  public User toEntity() throws FaultSetBuilderAttributesException {
    return new UserBuilder(new User())
            .setId(id)
            .setName(name)
            .setPassword(password)
            .setEmail(email)
            .setTimeTable(createdAt, updatedAt, deletedAt)
            .build();
  }

}
