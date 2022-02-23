package spring.community.mail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SendMailTest {

  @Mock
  MailService mailService;

  @Test
  void 이메일이_정상적으로_수신된다() {
    MailDto mailDto = new MailDto();
    mailDto.setEmail("galaxyhi4276@gmail.com");
    mailDto.setTitle("테스트용 메일 발신");
    mailDto.setMessage("est");

    mailService.sendMail(mailDto);
  }

}
