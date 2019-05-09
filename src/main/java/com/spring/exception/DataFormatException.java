package com.spring.exception;

public final class DataFormatException extends RuntimeException {

  private static final long serialVersionUID = 5843671134960022480L;

  public DataFormatException() {
    super();
  }

  public DataFormatException(String message, Throwable cause) {
    super(message, cause);
  }

  public DataFormatException(String message) {
    super(message);
  }

  public DataFormatException(Throwable cause) {
    super(cause);
  }
}
