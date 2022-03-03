package spring.community.authentication.dto;

/**
 * @desc 회원가입 요청 객체에 대한 에러 메시지를 정의합니다.
 */
public class SignupRequestError {

  public static final String FaultPatternName = "사용자 이름 형식이 맞지 않습니다.";

  public static final String FaultPatternPassword = "비밀번호 형식이 맞지 않습니다.";

  public static final String FaultPatternEmail = "이메일 형식이 아닙니다.";

  private SignupRequestError() { }

}
