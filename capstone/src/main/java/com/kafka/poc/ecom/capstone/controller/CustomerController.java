package com.kafka.poc.ecom.capstone.controller;

import com.kafka.poc.ecom.capstone.constant.CustomerConstant;
import com.kafka.poc.ecom.capstone.dto.CustomerDto;
import com.kafka.poc.ecom.capstone.dto.ErrorResponseDto;
import com.kafka.poc.ecom.capstone.dto.SuccessResponseDto;
import com.kafka.poc.ecom.capstone.service.ICustomerService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class CustomerController {

  @Autowired private ICustomerService iCustomerService;

  @ApiResponses({
    @ApiResponse(responseCode = "201", description = "HTTP Status CREATED"),
    @ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
  })
  @PostMapping(path = "/signUp")
  public ResponseEntity<SuccessResponseDto> RegisterCustomer(
      @Valid @RequestBody CustomerDto customerDto) {
    iCustomerService.createAccount(customerDto);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new SuccessResponseDto(CustomerConstant.STATUS_201, CustomerConstant.MESSAGE_201));
  }

  @GetMapping(path = "/login/{mobileNumber}/{password}")
  public ResponseEntity<SuccessResponseDto> login(
      @Valid @PathVariable String mobileNumber, String password) {
    iCustomerService.login(mobileNumber, password);
    return ResponseEntity.status(HttpStatus.OK)
        .body(new SuccessResponseDto(CustomerConstant.STATUS_200, CustomerConstant.MESSAGE_200));
  }
}
