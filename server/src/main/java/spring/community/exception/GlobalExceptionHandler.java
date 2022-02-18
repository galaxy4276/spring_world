package spring.community.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  /**
   * @desc Data Transfer Object(Dto) 에서 발생한 예외를 처리합니다.
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidationException(
    MethodArgumentNotValidException ex
  ) {
    log.error("handleValidationExceptions", ex);
    final ErrorResponse errResponse = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, ex.getBindingResult());
    return ResponseEntity.badRequest().body(errResponse);
  }
}
