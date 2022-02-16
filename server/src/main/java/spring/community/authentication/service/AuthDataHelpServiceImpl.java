package spring.community.authentication.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.community.authentication.dto.SignupVerificationDto;
import spring.community.authentication.entity.SignupVerification;
import spring.community.authentication.repository.SignupVerificationRepository;
import spring.community.user.entity.User;

import java.util.Date;

/**
 * @desc 비즈니스 로직에 필요한 데이터끼리의 직렬화/역직렬화 같은 유틸 기능을 제공합니다.
 */
@Service
@AllArgsConstructor
public class AuthDataHelpServiceImpl implements AuthDataHelpService {

  private final SignupVerificationRepository signupVerificationRepository;
  private final GenerateAuthKeyService generateAuthKeyService;

  @Override
  public SignupVerification findOrCreateSVByUser(User user) {
    return signupVerificationRepository.findByUserId(user.getId())
      .orElseGet(() -> {
        SignupVerification newSV = createSVEntityByDto(createSVDtoByUser(user));
        signupVerificationRepository.save(newSV);
        return newSV;
      });
  }

  private SignupVerification createSVEntityByDto(SignupVerificationDto svDto) {
    return SignupVerification.builder()
      .setId(svDto.getId())
      .setToken(svDto.getToken())
      .setExpiredAt(svDto.getExpiredAt())
      .setIsVerified(svDto.isVerified())
      .setUser(svDto.getUser())
      .setCreatedAt(svDto.getCreatedAt())
      .build();
  }

  private SignupVerificationDto createSVDtoByUser(User user) {
    return SignupVerificationDto.builder()
      .setId(user.getId())
      .setToken(generateAuthKeyService.GenerateSignupToken())
      .setCreatedAt(null) // TODO: 22. 2. 16. 맞는 값 넣기
      .setExpiredAt(null) // TODO: 22. 2. 15. 추가 기간 더해서 수정해야함
      .setUser(user)
      .setIsVerified(false)
      .build();
  }

}
