package spring.community.entity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.community.user.dto.UserDto;
import spring.community.user.entity.User;

import java.util.function.Function;

@DisplayName("Dto와 Entity 간 Serialize/Deserialize 테스트")
public class DataSerializeAndDeserializeTest {
  private final String 이게_사람이름이냐 = "엄준식";

  UserDto generateUserDto() {
    return UserDto.builder()
      .setName(이게_사람이름이냐)
      .setPassword("@Umjunsik12")
      .setEmail("icantBelieve@howumispeople.name")
      .build();
  }

  @Test
  void userDto가_정상적으로_생성된다() {
    UserDto userDto = generateUserDto();
    assertThat(userDto).isInstanceOf(UserDto.class);
    assertThat(userDto.getName()).isSameAs(이게_사람이름이냐);
  }

  @Test
  void userDto를_User엔티티로_성공적으로_변환한다() {
    User user = generateUserDto().toEntity();
    assertThat(user).isInstanceOf(User.class);
    assertThat(user.getName()).isSameAs("엄준식");
  }

  @Test
  void User엔티티를_userDto로_성공적으로_변환한다() {
    Function<UserDto, User> generateUser = UserDto::toEntity;
    User user = generateUser.apply(generateUserDto());
    UserDto userDto = user.toUserDto();
    assertThat(userDto).isInstanceOf(UserDto.class);
    assertThat(userDto.getName()).isSameAs("엄준식");
  }

}
