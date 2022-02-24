package spring.community.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.community.authentication.exception.AlreadyExistsUserException;
import spring.community.authentication.exception.AlreadyUserNameException;

import java.util.List;

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

  @ExceptionHandler(AlreadyExistsUserException.class)
  public ResponseEntity<ErrorResponse> handleAlreadyExistsUserException(
    AlreadyExistsUserException ex
  ) {
    log.error("handleAlreadyExistsUserException", ex);
    List<ErrorResponse.FieldError> errors =
      ErrorResponse.FieldError.of(ex.getEmail(), "", ex.getMessage());
    final ErrorResponse errorResponse = ErrorResponse.of(ex.getMessage(), ex.getErrorCode(), errors);
    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
  }

  @ExceptionHandler(AlreadyUserNameException.class)
  public ResponseEntity<ErrorResponse> handleAlreadyUserNameException(
    AlreadyUserNameException ex
  ) {
    List<ErrorResponse.FieldError> errors =
      ErrorResponse.FieldError.of(ex.getName(), "", ex.getMessage());
    final ErrorResponse errorResponse = ErrorResponse.of(ex.getMessage(), ex.getErrorCode(), errors);
    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
  }

}
