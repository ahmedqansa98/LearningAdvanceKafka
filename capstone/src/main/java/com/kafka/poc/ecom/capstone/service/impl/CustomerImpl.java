package com.kafka.poc.ecom.capstone.service.impl;

import com.kafka.poc.ecom.capstone.dto.CustomerDto;
import com.kafka.poc.ecom.capstone.entity.CustomerEntity;
import com.kafka.poc.ecom.capstone.exception.CustomerAlreadyExistsException;
import com.kafka.poc.ecom.capstone.mapper.CustomerMapper;
import com.kafka.poc.ecom.capstone.repository.CustomerRepo;
import com.kafka.poc.ecom.capstone.service.ICustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerImpl implements ICustomerService {

  @Autowired private CustomerRepo customerRepo;

  /**
   * @param customerDto - CustomerDto Object
   */
  @Override
  public void createAccount(CustomerDto customerDto) {
    CustomerEntity customerEntity =
        CustomerMapper.mapToCustomerEntity(customerDto, new CustomerEntity());
    Optional<CustomerEntity> optionalCustomer =
        customerRepo.findByMobileNumber(customerDto.getMobileNumber());
    if (optionalCustomer.isPresent()) {
      throw new CustomerAlreadyExistsException(
          "CustomerEntity already registered with given mobileNumber!! Please Login "
              + customerDto.getMobileNumber());
    }
    CustomerEntity savedCustomer = customerRepo.save(customerEntity);
    customerRepo.save(savedCustomer);
  }

  /***
   *  @param mobileNumber
   * @param password
   */
  @Override
  public void login(String mobileNumber, String password) {
    try {
      Optional<CustomerDto> loginByMobileNumber =
          customerRepo.findByMobileNumberAndEmail(mobileNumber, password);
      if (loginByMobileNumber.isPresent()) {
        log.info("Logged in Successfully!! Welcome to the Ecommerce");
      }
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }
}
