package spring.community.exception;

public class NotFoundTargetException extends BusinessException {

  public NotFoundTargetException() {
    super("찾을 수 없는 대상입니다.", ErrorCode.NOT_FOUND_TARGET);
  }

}
