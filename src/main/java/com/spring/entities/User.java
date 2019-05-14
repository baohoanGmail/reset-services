package com.spring.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

  private String id;
  private String createdAt;
  private String name;
  private String avatar;

  
  public User() {
    this.id = "";
    this.createdAt = "";
    this.name = "";
    this.avatar = "";
  }

  public User(String id, String createdAt, String name, String avatar) {
    this.id = id;
    this.createdAt = createdAt;
    this.name = name;
    this.avatar = avatar;
  }

  public User(String createdAt, String name, String avatar) {
    super();
    this.createdAt = createdAt;
    this.name = name;
    this.avatar = avatar;
  }

}
