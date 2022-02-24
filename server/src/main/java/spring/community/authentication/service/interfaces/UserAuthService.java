package spring.community.authentication.service.interfaces;

import spring.community.authentication.dto.SignupRequestDto;
import spring.community.authentication.entity.SignupVerification;
import spring.community.user.entity.User;

/**
 * @desc userRepository 기반으로 인증 시스템에서 요구하는 유저 데이터 조작/반환, 예외 처리
 * @apiNote 필요한 비즈니스 로직
 * signupRequestDto 정보 기반으로 유저 생성
 * signupRequestDto 기반으로의 기존 유저가 있는 지 검증. ( 이메일이 같은 예외 케이스 존재 )
 * SignupVerification 정보를 기반으로 가입 인증이 안되어있는 유저의 새로운 인증 요청에 대해 유저 정보 변경 수행
 * @implSpec 단순 유저 조회, 수정, 삭제, 생성 같은 로직 추가 금지
 */
public interface UserAuthService {
  // SignupRequestDto 정보 기반으로 유저 생성
  public User createUserByDto(
    SignupRequestDto signupRequestDto
  );

  // signupRequestDto 정보 기반으로 이미 존재하는 유저이름인 지 검증
  public void verifyAlreadyExistsUsernameByDto(
    SignupRequestDto signupRequestDto
  );

  // 인증이 안되어있는 유저가 새로 회원가입 요청 시, 유저 정보 갱신
  public void updateUnVerifiedUserInfo(
    SignupRequestDto signupRequestDto,
    User user,
    SignupVerification signupVerification
  );

}
