package com.multipolar.bootcamp.bankAccount.service;

import com.multipolar.bootcamp.bankAccount.domain.BankAccount;
import com.multipolar.bootcamp.bankAccount.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    //GET ALL ACCOUNT
    public List<BankAccount> getAllAccount(){return bankAccountRepository.findAll();
    }

    //GET ACCOUNT by ID
    public Optional<BankAccount> getAccountById(String id){
        return bankAccountRepository.findById(id);
    }



    //Create or Update ACCOUNT
    public BankAccount createOrUpdateAccount(BankAccount bankAccount){
        return bankAccountRepository.save(bankAccount);
    }

    //DELETE ACCOUNT by ID
    public void deleteAccountById(String id){
        bankAccountRepository.deleteById(id);
    }
}
