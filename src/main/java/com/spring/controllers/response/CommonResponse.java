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
public class CommonResponse implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -4984981421445439339L;

  /** The status. */
  private int status;

  /** The total. */
  @JsonInclude(Include.NON_NULL)
  private Integer total;

  /** The data. */
  private Object data;

  /**
   * Instantiates a new common response.
   *
   * @param status the status
   * @param data the data
   */
  public CommonResponse(int status, Object data) {
    this.status = status;
    this.data = data;
  }

}
