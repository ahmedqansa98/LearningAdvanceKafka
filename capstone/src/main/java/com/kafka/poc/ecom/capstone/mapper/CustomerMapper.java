package com.kafka.poc.ecom.capstone.mapper;

import com.kafka.poc.ecom.capstone.dto.CustomerDto;
import com.kafka.poc.ecom.capstone.entity.CustomerEntity;

public class CustomerMapper {
  public static CustomerDto mapToCustomerDto(
          CustomerEntity customerEntity, CustomerDto customerDto) {
    customerDto.setCustomerName(customerEntity.getCustomerName());
    customerDto.setDob(customerEntity.getDob());
    customerDto.setCurrentAddress(customerEntity.getCurrentAddress());
    customerDto.setMobileNumber(customerEntity.getMobileNumber());
    customerDto.setCreatePassword(customerEntity.getCreatePassword());
    customerDto.setEmail(customerEntity.getEmail());
    return customerDto;
  }

  public static CustomerEntity mapToCustomerEntity(
      CustomerDto customerDto, CustomerEntity customerEntity) {
    customerEntity.setCustomerName(customerDto.getCustomerName());
    customerEntity.setDob(customerDto.getDob());
    customerEntity.setCurrentAddress(customerDto.getCurrentAddress());
    customerEntity.setMobileNumber(customerDto.getMobileNumber());
    customerEntity.setCreatePassword(customerDto.getCreatePassword());
    customerEntity.setEmail(customerDto.getEmail());
    return customerEntity;
  }
}
