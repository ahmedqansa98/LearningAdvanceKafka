package com.kafka.poc.ecom.capstone.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
  @GenericGenerator(strategy = "native", name = "native")
  private Long customerId;

  @Column(name = "customer_name")
  private String customerName;

  @Column(name = "mobile_number")
  private String mobileNumber;

  @Column(name = "customer_dob")
  private String dob;

  @Column(name = "customer_address")
  private String currentAddress;

  @Column(name = "password")
  private String createPassword;

  @Column(name = "customerEmail")
  @Pattern(regexp = "^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*$")
  private String email;

  private boolean blocked;
}
