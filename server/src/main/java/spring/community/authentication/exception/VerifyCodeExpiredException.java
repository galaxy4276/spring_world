package spring.community.authentication.exception;

import spring.community.exception.BusinessException;
import spring.community.exception.ErrorCode;

public class VerifyCodeExpiredException extends BusinessException {
  private String email;

  public VerifyCodeExpiredException(String email) {
    super("사용자 인증이 만료되었습니다.", ErrorCode.INVALID_TARGET);
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

}
