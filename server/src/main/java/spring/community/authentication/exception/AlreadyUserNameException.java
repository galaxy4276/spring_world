package spring.community.authentication.exception;

import spring.community.exception.BusinessException;
import spring.community.exception.ErrorCode;

public class AlreadyUserNameException extends BusinessException {
  private String name;

  public AlreadyUserNameException(String name) {
    super("이미 존재하는 유저이름입니다.", ErrorCode.ALREADY_EXISTS_TARGET);
    this.name = name;
  }

  public String getName() {
    return name;
  }

}
