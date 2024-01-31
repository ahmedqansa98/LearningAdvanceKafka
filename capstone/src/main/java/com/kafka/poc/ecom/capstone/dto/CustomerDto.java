package com.kafka.poc.ecom.capstone.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {
  @NotBlank private String customerName;
  @NotBlank private String mobileNumber;
  @NotBlank private String dob;
  @NotBlank private String currentAddress;
  @NotBlank private String createPassword;
  @NotBlank private String email;
}
