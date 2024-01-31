package com.kafka.poc.ecom.capstone.repository;

import com.kafka.poc.ecom.capstone.dto.CustomerDto;
import com.kafka.poc.ecom.capstone.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {

  /**
   * @param mobileNumber - Input Mobile Number
   * @return Accounts Details based on a given mobileNumber
   */
  Optional<CustomerEntity> findByMobileNumber(String mobileNumber);

  Optional<CustomerDto> findByMobileNumberAndEmail(String mobileNumber, String password);
}
