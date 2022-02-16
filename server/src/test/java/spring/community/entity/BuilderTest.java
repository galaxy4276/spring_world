package spring.community.entity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.community.user.dto.UserDto;
import spring.community.user.entity.User;

@DisplayName("엔티티 빌더 생성 테스트")
public class BuilderTest {
  private UserDto userDto;
  private User user;

  @Test
  void userDto가_정상적으로_생성된다() {
    String 이게_사람이름이냐 = "엄준식";
    UserDto userDto = UserDto.builder()
      .setName(이게_사람이름이냐)
      .setPassword("@Umjunsik12")
      .setEmail("icantBelieve@howumispeople.name")
      .build();
    this.userDto = userDto;
    assertThat(userDto).isInstanceOf(UserDto.class);
    assertThat(userDto.getName()).isSameAs(이게_사람이름이냐);
  }

  @Test
  void userDto를_User엔티티로_성공적으로_변환한다() {
    User user = userDto.toEntity();
    this.user = user;
    assertThat(user).isInstanceOf(User.class);
    assertThat(user.getName()).isSameAs("엄준식");
  }

  @Test
  void User엔티티를_userDto로_성공적으로_변환한다() {
     UserDto successfullyDto = user.toUserDto();
     assertThat(successfullyDto).isInstanceOf(user.getClass());
     assertThat(successfullyDto.getName()).isSameAs("엄준식");
  }

}
