package com.jjcc.bootlaunch.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @title
 * @author Jjcc
 * @createTime 2019/11/10 13:49
 */
@Data
public class Person implements Serializable {

  private static final long serialVersionUID = -8985545025228238754L;

  String id;
  String firstName;
  String lastName;
  Address address;

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}