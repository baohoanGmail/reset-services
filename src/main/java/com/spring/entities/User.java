package com.spring.entities;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Serializable {

  private static final long serialVersionUID = 431382374075800767L;

  private int id;
  private String createAt;
  private String name;
  private String avarta;

  public User(int id, String createAt, String name, String avarta) {
    this.id = id;
    this.createAt = createAt;
    this.name = name;
    this.avarta = avarta;
  }

}
