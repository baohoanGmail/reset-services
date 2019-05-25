package com.spring.entities;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product implements Serializable {

  private static final long serialVersionUID = -7147096106786511555L;
  private String id;
  private String name;
}
