package spring.community.exception;

public class InvalidValueException extends BusinessException {

  private String value;
  private String field;

  public InvalidValueException(String field, String value) {
    super(ErrorCode.INVALID_INPUT_VALUE);
    this.field = field;
    this.value = value;
  }

  public String getValue() {
    return value;
  }
  public String getField() { return field; }

}
