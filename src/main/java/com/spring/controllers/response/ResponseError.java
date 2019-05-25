package com.spring.controllers.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseError {

  public final String detail;
  public final String message;

  public ResponseError(Exception ex, String detail) {
    this.message = ex.getLocalizedMessage();
    this.detail = detail;
  }
}
