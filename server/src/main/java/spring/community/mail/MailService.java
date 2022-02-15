package spring.community.mail;

public interface MailService {

  // 이메일을 보냅니다.
  public void sendMail(MailDto sendInfo);

  // 사용자 회원가입 인증을 위한 이메일을 보냅니다.
  public void sendUserJoinVerificationMail(String key, String username, String email);

  // 사용자 패스워드 찾기 인증을 위한 이메일을 보냅니다.
  public void sendUserOneTimePasswordVerificationMail();

}
