package spring.community.authentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.community.exception.BusinessException;
import spring.community.exception.ErrorResponse;

import java.util.List;

@RestControllerAdvice
public class AuthExceptionHandler {

  @ExceptionHandler(AlreadyExistsUserException.class)
  public ResponseEntity<ErrorResponse> handleAlreadyExistsUserException(
    AlreadyExistsUserException ex
  ) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(
      getErrorResponseByConflict(ex.getEmail(), ex)
    );
  }

  @ExceptionHandler(AlreadyUserNameException.class)
  public ResponseEntity<ErrorResponse> handleAlreadyUserNameException(
    AlreadyUserNameException ex
  ) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(
      getErrorResponseByConflict(ex.getName(), ex)
    );
  }

  private ErrorResponse getErrorResponseByConflict(String target, BusinessException ex) {
    String message = ex.getMessage();
    List<ErrorResponse.FieldError> errors =
      ErrorResponse.FieldError.of(target, "", message);
    return ErrorResponse.of(message, ex.getErrorCode(), errors);
  }

}
