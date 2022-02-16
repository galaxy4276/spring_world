package spring.community.authentication.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.community.authentication.dto.SignupVerificationDto;
import spring.community.authentication.entity.SignupVerification;
import spring.community.authentication.repository.SignupVerificationRepository;
import spring.community.authentication.service.interfaces.AuthDataHelpService;
import spring.community.authentication.service.interfaces.GenerateAuthKeyService;
import spring.community.user.entity.User;

import java.time.LocalDateTime;

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

  @Override
  public LocalDateTime getExpiredDateByNow(Integer minutes) {
    return LocalDateTime.now().plusMinutes(minutes);
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
      .setExpiredAt(getExpiredDateByNow(30))
      .setUser(user)
      .setIsVerified(false)
      .build();
  }

}
