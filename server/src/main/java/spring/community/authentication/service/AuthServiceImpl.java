package spring.community.authentication.service;

import spring.community.mail.MailService;
import spring.community.user.repository.dao.UserRepository;

public class AuthServiceImpl implements AuthService {

  private final UserRepository userRepository;
  private final MailService mailService;

  public AuthServiceImpl(UserRepository userRepository, MailService mailService) {
    this.userRepository = userRepository;
    this.mailService = mailService;
  }

  @Override
  public void signup() {

  }

}
