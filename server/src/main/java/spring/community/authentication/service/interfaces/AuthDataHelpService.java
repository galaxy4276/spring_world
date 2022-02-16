package spring.community.authentication.service.interfaces;

import spring.community.authentication.entity.SignupVerification;
import spring.community.user.entity.User;

import java.time.LocalDateTime;

public interface AuthDataHelpService {

  // 유저 정보 데이터로 유저인증 엔티티 객체를 찾거나 생성하여 반환합니다.
  public SignupVerification findOrCreateSVByUser(User user);

  // 현재 시간 대 기반으로 인자가 더해진 만료 시간을 반환합니다.
  public LocalDateTime getExpiredDateByNow(Integer minutes);

}
