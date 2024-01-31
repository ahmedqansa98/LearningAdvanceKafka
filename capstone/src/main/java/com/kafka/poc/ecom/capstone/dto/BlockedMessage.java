package com.kafka.poc.ecom.capstone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlockedMessage {
  private String blockedDateTime;
  private String username;
}
