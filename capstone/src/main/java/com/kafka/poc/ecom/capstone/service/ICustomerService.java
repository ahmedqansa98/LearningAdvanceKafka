package com.kafka.poc.ecom.capstone.service;

import com.kafka.poc.ecom.capstone.dto.CustomerDto;

public interface ICustomerService {
  /**
   * @param customerDto - CustomerDto Object
   */
  void createAccount(CustomerDto customerDto);

  /***
   *
   * @param mobileNumber
   * @param password
   */
  void login(String mobileNumber, String password);
}
