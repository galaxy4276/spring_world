package spring.community.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
   * @desc Data Transfer Object(Dto) 에서 발생한 예외를 처리합니다.
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidationException(
    MethodArgumentNotValidException ex
  ) {
    final ErrorResponse errResponse = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, ex.getBindingResult());
    return ResponseEntity.badRequest().body(errResponse);
  }

  @ExceptionHandler(NotFoundTargetException.class)
  public ResponseEntity<ErrorResponse> handleNotFoundException(
    NotFoundTargetException ex
  ) {
    final ErrorResponse errorResponse = ErrorResponse.of(ex.getErrorCode());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }

  @ExceptionHandler(InvalidValueException.class)
  public ResponseEntity<ErrorResponse> handleInvalidValueException(
    InvalidValueException ex
  ) {
    List<ErrorResponse.FieldError> errors =
      ErrorResponse.FieldError.of(ex.getField(), ex.getValue(), ex.getMessage());

    final ErrorResponse errorResponse = ErrorResponse.of(
      ex.getValue(),
      ex.getErrorCode(),
      errors
      );
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }

}
