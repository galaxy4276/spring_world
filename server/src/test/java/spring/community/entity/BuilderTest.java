package spring.community.entity;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import spring.community.exception.FaultSetBuilderAttributesException;
import spring.community.user.entity.User;
import spring.community.user.entity.builder.RoleBuilder;
import spring.community.user.entity.builder.UserBuilder;

import java.util.Date;

public class BuilderTest {
  UserBuilder userBuilder = new UserBuilder();
  RoleBuilder roleBuilder = new RoleBuilder();

  @Test
  void UserBuilder_필드설정이_빠져있다면_예외발생() {
    assertThrows(FaultSetBuilderAttributesException.class, () -> {
      userBuilder.build();
    });
  }

  @Test
  void UserBuilder_필드설정이_올바르다면_통과() throws FaultSetBuilderAttributesException {
    User user = userBuilder
            .setId(1L)
            .setName("엄준식")
            .setEmail("isUmHowPeople@name.com")
            .setTimeTable(new Date(), new Date(), null)
            .setPassword("@IsUmICantBelieve12")
            .build();
    assertThat(user).isInstanceOf(User.class);
  }

  @Test
  void RoleBuilder_필드설정이_빠져있다면_예외발생() {
    assertThrows(FaultSetBuilderAttributesException.class, () -> {
      roleBuilder.build();
    });
  }

}
