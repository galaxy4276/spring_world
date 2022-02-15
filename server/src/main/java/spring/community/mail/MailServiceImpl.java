package spring.community.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import spring.community.authentication.service.GenerateAuthKeyService;

@Component
public class MailServiceImpl implements MailService {

  private final JavaMailSender mailSender;

  public MailServiceImpl(GenerateAuthKeyService generateAuthKeyService, JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  @Override
  public void sendMail(MailDto sendInfo) {
    SimpleMailMessage ctx = new SimpleMailMessage();
    ctx.setTo(sendInfo.getEmail());
    ctx.setSubject(sendInfo.getTitle());
    ctx.setText(sendInfo.getMessage());

    mailSender.send(ctx);
  }

  @Override
  public void sendUserJoinVerificationMail(String token, String username, String email) {
    SimpleMailMessage ctx = new SimpleMailMessage();
    ctx.setTo(email);
    ctx.setSubject("'이런 서버쟁이들' 에서 보내는 인증 코드입니다.");
    ctx.setText(
      "'이런 서버쟁이들' 서버 개발자들의 소통 서비스에 가입해주셔서 감사합니다.\n" +
        "아래 URL 을 클릭하여 메일 인증을 수행해주세요." +
        "url: " + "http://localhost/auth/signup/mail/verification/" +
        token
    );
    mailSender.send(ctx);
  }

  @Override
  public void sendUserOneTimePasswordVerificationMail() {}

}
