package com.multipolar.bootcamp.bankAccount.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AccountHolder{
    private String nik;
    private String name;
    private String address;
}
