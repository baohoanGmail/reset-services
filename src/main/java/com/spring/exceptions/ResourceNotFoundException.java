package com.spring.exceptions;

public class ResourceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -3237858028730472713L;

  public ResourceNotFoundException() {
    super();
  }

  public ResourceNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public ResourceNotFoundException(String message) {
    super(message);
  }

  public ResourceNotFoundException(Throwable cause) {
    super(cause);
  }
}
