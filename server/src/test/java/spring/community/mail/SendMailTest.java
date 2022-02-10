package spring.community.mail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SendMailTest {

  @Autowired
  private MailService mailService;

  @Test
  void 이메일이_정상적으로_수신된다() {
    MailDto mailDto = new MailDto();
    mailDto.setEmail("galaxyhi4276@gmail.com");
    mailDto.setTitle("테스트용 메일 발신");
    mailDto.setMessage("est");

    mailService.sendMail(mailDto);

  }

}
