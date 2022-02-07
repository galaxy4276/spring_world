package spring.community.user.entity.builder;

import spring.community.exception.FaultSetBuilderAttributesException;
import spring.community.helper.entity.FullTimeStamp;
import spring.community.user.entity.User;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Stream;

public class UserBuilder {
  private final User user;

  public UserBuilder(User user) {
    this.user = user;
  }

  public UserBuilder setId(Long id) {
    this.user.setId(id);
    return this;
  }

  public UserBuilder setName(String name) {
    this.user.setName(name);
    return this;
  }

  public UserBuilder setPassword(String password) {
    this.user.setPassword(password);
    return this;
  }

  public UserBuilder setEmail(String email) {
    this.user.setEmail(email);
    return this;
  }

  public UserBuilder setTimeTable(Date createdAt, Date updatedAt, Date deletedAt) {
    FullTimeStamp fullTimeStamp = new FullTimeStamp();
    fullTimeStamp.setCreatedAt(createdAt);
    fullTimeStamp.setUpdatedAt(updatedAt);
    fullTimeStamp.setDeletedAt(deletedAt);
    this.user.setFullTimeStamp(fullTimeStamp);
    return this;
  }

  public User build() throws FaultSetBuilderAttributesException {
    if (Stream.of(
            user.getId(),
            user.getName(),
            user.getPassword(),
            user.getEmail(),
            user.getFullTimeStamp().getCreatedAt(),
            user.getFullTimeStamp().getUpdatedAt(),
            user.getFullTimeStamp().getDeletedAt()
    ).allMatch(Objects::isNull)) {
      throw new FaultSetBuilderAttributesException("필드 설정이 잘못되었습니다.");
    }
    return this.user;
  }

}
