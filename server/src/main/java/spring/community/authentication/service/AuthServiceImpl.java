package spring.community.authentication.service;

import org.springframework.stereotype.Service;
import spring.community.authentication.entity.SignupVerification;
import spring.community.authentication.repository.SignupVerificationRepository;
import spring.community.mail.MailService;
import spring.community.user.repository.dao.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

  private final UserRepository userRepository;
  private final MailService mailService;

  private final SignupVerificationRepository signupVerificationRepository;

  public AuthServiceImpl(
    UserRepository userRepository,
    MailService mailService,
    SignupVerificationRepository signupVerificationRepository) {
    this.userRepository = userRepository;
    this.mailService = mailService;
    this.signupVerificationRepository = signupVerificationRepository;
  }

  @Override
  public void signup() {

  }

  @Override
  public void sendSignupVerificationUrl(String email) {
    SignupVerification signupVerification = signupVerificationRepository.findByToken(email);
    System.out.println(signupVerification);
  }

}
