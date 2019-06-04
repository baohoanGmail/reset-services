package com.spring.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.controllers.response.RestResponse;
import com.spring.entities.Product;

@RestController
@RequestMapping(value = "api/v1/products", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProductController extends AbstractRestHandler {

  private static List<Product> products = null;
  static {
    products = new ArrayList<>();
    for (int i = 0; i < 50; i++) {
      products.add(new Product(String.valueOf(i), "Name ".concat(String.valueOf(i))));
    }
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<RestResponse> getProducts(@PathVariable(required = true, name = "id") String id) {
    Optional<Product> oProduct = products.stream().filter(p -> id.equals(p.getId())).findAny();
    if (oProduct.isPresent()) {
      return new ResponseEntity<RestResponse>(new RestResponse(oProduct.get()), HttpStatus.OK);
    }
    return new ResponseEntity<RestResponse>(new RestResponse(), HttpStatus.NOT_FOUND);
  }

}
