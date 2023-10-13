package com.multipolar.bootcamp.gatewayAccount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AccountHolderDTO {
    private String nik;
    private String name;
    private String address;
}
