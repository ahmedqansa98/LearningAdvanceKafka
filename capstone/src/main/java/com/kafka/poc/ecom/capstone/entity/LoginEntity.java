package com.kafka.poc.ecom.capstone.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginEntity {

  private String mobileNumber;
  private String password;
}
