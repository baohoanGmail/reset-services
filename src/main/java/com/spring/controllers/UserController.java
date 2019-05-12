package com.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.spring.entities.User;
import com.spring.helper.JsonHelper;
import com.spring.helper.RestHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author hoan.lam
 *
 */

@RestController
@RequestMapping(value = "api/v1/users")
@Api(tags = {"user"})
@Slf4j
public class UserController extends AbstractRestHandler {

  @RequestMapping(value = "/{username}", method = RequestMethod.GET,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public String index(
      @ApiParam(value = "The username of the USER.",
          required = true) @PathVariable("username") String username,
      HttpServletRequest request, HttpServletResponse response) {
    checkResourceFound(username, true);
    return JsonHelper.object2String(username, User.class.getName());
  }

  @ApiOperation(value = "Create a user resource.",
      notes = "Returns the URL of the new resource in the Location header.")
  @RequestMapping(value = "", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public boolean create(@RequestBody User user, HttpServletRequest request,
      HttpServletResponse response) {
    log.info("Create user api is starting...");
    checkResourceFound(user, false);
    ResponseEntity<?> restResponse =
        RestHelper.post(RestHelper.getEndpoint("/users"), user, User.class);
    return (restResponse.hasBody());
  }
}
