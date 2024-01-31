package com.kafka.poc.ecom.capstone.exception;

public class IncorrectCredentialsException extends Exception {
  public IncorrectCredentialsException(String msg) {
    super(msg);
  }
}
