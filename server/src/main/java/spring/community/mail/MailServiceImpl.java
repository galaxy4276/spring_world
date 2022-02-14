package spring.community.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailServiceImpl implements MailService {

  @Autowired
  private JavaMailSender mailSender;

  @Override
  public void sendMail(MailDto sendInfo) {
    SimpleMailMessage ctx = new SimpleMailMessage();
    ctx.setTo(sendInfo.getEmail());
    ctx.setSubject(sendInfo.getTitle());
    ctx.setText(sendInfo.getMessage());

    mailSender.send(ctx);
  }

  @Override
  public void sendUserJoinVerificationMail() {}

  @Override
  public void sendUserOneTimePasswordVerificationMail() {}

}
