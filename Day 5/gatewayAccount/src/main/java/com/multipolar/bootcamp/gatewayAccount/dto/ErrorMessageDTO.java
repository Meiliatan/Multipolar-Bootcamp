package com.multipolar.bootcamp.gatewayAccount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorMessageDTO {
    private String code;
    private String message;
}
