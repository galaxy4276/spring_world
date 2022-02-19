package spring.community.authentication.exception;

import spring.community.exception.BusinessException;
import spring.community.exception.ErrorCode;

public class AlreadyExistsUserException extends BusinessException {
  private final String email;

  public AlreadyExistsUserException(String email) {
    super("이미 회원가입 된 유저입니다.", ErrorCode.ALREADY_EXISTS_TARGET);
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

}
