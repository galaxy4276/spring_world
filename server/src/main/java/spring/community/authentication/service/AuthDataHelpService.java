package spring.community.authentication.service;

import spring.community.authentication.entity.SignupVerification;
import spring.community.user.entity.User;

public interface AuthDataHelpService {

  // 유저 정보 데이터로 유저인증 엔티티 객체를 찾거나 생성하여 반환합니다.
  public SignupVerification findOrCreateSVByUser(User user);

}
