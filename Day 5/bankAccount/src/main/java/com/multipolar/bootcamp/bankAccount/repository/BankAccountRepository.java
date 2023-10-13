package com.multipolar.bootcamp.bankAccount.repository;

import com.multipolar.bootcamp.bankAccount.domain.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankAccountRepository extends MongoRepository<BankAccount, String> {
}
