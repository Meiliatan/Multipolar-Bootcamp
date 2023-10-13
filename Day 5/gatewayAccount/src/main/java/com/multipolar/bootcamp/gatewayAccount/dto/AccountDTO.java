package com.multipolar.bootcamp.gatewayAccount.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class AccountDTO implements Serializable {
    private String id;
    private String accountNumber;
    private AccountTypeDTO accountType;
    private AccountStatusDTO accountStatus;
    private AccountHolderDTO accountHolder;
    private Double balance;
    private LocalDateTime openingDate = LocalDateTime.now();
    private LocalDate closingDate;

}
