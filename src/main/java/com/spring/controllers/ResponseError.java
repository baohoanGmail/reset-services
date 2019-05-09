package com.spring.controllers;

public class ResponseError {

  public final String detail;
  public final String message;

  public ResponseError(Exception ex, String detail) {
    this.message = ex.getLocalizedMessage();
    this.detail = detail;
  }
}
