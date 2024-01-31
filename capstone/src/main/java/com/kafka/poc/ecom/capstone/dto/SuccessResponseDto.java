package com.kafka.poc.ecom.capstone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SuccessResponseDto {
  private String statusCode;
  private String resMsg;
}
