package com.spring.controllers;

import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import com.spring.controllers.response.ResponseError;
import com.spring.exceptions.BadRequestException;
import com.spring.exceptions.DataFormatException;
import com.spring.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;

/**
 * This class is meant to be extended by all REST resource "controllers". It contains exception
 * mapping and other common REST API functionality
 */

@Slf4j
public abstract class AbstractRestHandler implements ApplicationEventPublisherAware {

  protected ApplicationEventPublisher eventPublisher;

  protected static final String DEFAULT_PAGE_SIZE = "100";
  protected static final String DEFAULT_PAGE_NUM = "0";

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(DataFormatException.class)
  public @ResponseBody ResponseError handleDataStoreException(DataFormatException ex,
      WebRequest request, HttpServletResponse response) {
    log.info("Converting Data Store exception to RestResponse: {}", ex.getMessage());
    return new ResponseError(ex, "You messed up.");
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(ResourceNotFoundException.class)
  public @ResponseBody ResponseError handleResourceNotFoundException(ResourceNotFoundException ex,
      WebRequest request, HttpServletResponse response) {
    log.info("ResourceNotFoundException handler: {}", ex.getMessage());
    return new ResponseError(ex, "Sorry I couldn't find it.");
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(BadRequestException.class)
  public @ResponseBody ResponseError handleBadRequestException(BadRequestException ex,
      WebRequest request, HttpServletResponse response) {
    log.info("BadRequestException handler: {}", ex.getMessage());
    return new ResponseError(ex, "The parameters are not valid");
  }

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.eventPublisher = applicationEventPublisher;
  }

  /**
   * 
   * @param resource the object needs to check null
   * @param throwException force to throw an exception
   * @return
   */
  public static <T> T checkResourceFound(final T resource, boolean throwException) {
    if (throwException || resource == null) {
      throw new ResourceNotFoundException("resource not found");
    }
    return resource;
  }
}
