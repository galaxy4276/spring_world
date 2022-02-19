package spring.community.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

  INVALID_INPUT_VALUE("IIV01", "입력 값이 잘못되었습니다."),
  ALREADY_EXISTS_TARGET("AET01", "이미 존재하는 대상입니다."),
  ;

  private String code;
  private String message;

  ErrorCode(final String code, final String message) {
   this.code = code;
   this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
