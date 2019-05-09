package com.spring.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import com.spring.entities.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestHelper {

  @Value("${spring.application.endpoint}")
  private static String endpoint;

  private static final String getEndpoint(String type) {
    if ("users".equalsIgnoreCase(type)) {
      return endpoint.concat("/users");
    }
    return endpoint;
  }


  public static final User create(User data) {
    String api = getEndpoint("users");
    log.info("start calling api {}", api);
    RestTemplate restTemplate = new RestTemplate();
    User result = restTemplate.postForObject(api, data, User.class);
    log.info("Create result {}", JsonHelper.object2String(result, User.class.getName()));
    return result;
  }

}
