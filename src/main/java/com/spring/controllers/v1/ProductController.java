package com.spring.controllers.v1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.spring.controllers.response.CommonResponse;
import com.spring.entities.Product;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/v1/products")
@CrossOrigin(maxAge = 3600)
public class ProductController {

  @ApiOperation(value = "Get all products", response = CommonResponse.class)
  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<Object> getAllAccounts(HttpServletRequest request,
      HttpServletResponse response) throws IOException {

    List<Product> products = new ArrayList<>();
    return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(), products), HttpStatus.OK);
  }

}
