package com.kafka.poc.ecom.capstone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseDto {

  private String errorMsg;
  private HttpStatus errorStatusCode;
  private String apiPath;
  private LocalDateTime errorTime;
}
