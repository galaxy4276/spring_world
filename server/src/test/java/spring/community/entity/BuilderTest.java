package spring.community.entity;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.community.exception.FaultSetBuilderAttributesException;
import spring.community.user.entity.User;

import java.util.Date;

@DisplayName("엔티티 빌더 생성 테스트")
public class BuilderTest {
//  UserBuilder userBuilder = new UserBuilder();
//  RoleBuilder roleBuilder = new RoleBuilder();
// TODO: 22. 2. 16. 테스트 다시 작성할 예정
  @Test
  void UserBuilder_필드설정이_빠져있다면_예외발생() {
    assertThrows(FaultSetBuilderAttributesException.class, () -> {
    });
  }

  @Test
  void UserBuilder_필드설정이_올바르다면_통과() throws FaultSetBuilderAttributesException {
//    User user = userBuilder
//            .setId(1L)
//            .setName("엄준식")
//            .setEmail("isUmHowPeople@name.com")
//            .setTimeTable(new Date(), new Date(), null)
//            .setPassword("@IsUmICantBelieve12")
//            .build();
//    assertThat(user).isInstanceOf(User.class);
  }

  @Test
  void RoleBuilder_필드설정이_빠져있다면_예외발생() {
    assertThrows(FaultSetBuilderAttributesException.class, () -> {
//      roleBuilder.build();
    });
  }

}
