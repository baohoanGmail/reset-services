package com.spring.controllers.response;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RestResponse implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -4984981421445439339L;

  /** The status. */
  private String status;

  /** The data. */
  @JsonInclude(content = Include.NON_NULL)
  private Object data;

  public RestResponse() {
    this.status = "success";
    this.data = null;
  }

  public RestResponse(Object data) {
    this.status = "success";
    this.data = data;
  }
}
