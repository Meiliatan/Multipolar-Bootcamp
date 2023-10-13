package com.multipolar.bootcamp.bankAccount.controller;

import com.multipolar.bootcamp.bankAccount.domain.BankAccount;
import com.multipolar.bootcamp.bankAccount.dto.ErrorMessage;
import com.multipolar.bootcamp.bankAccount.service.BankAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {

    private final BankAccountService bankAccountService;


    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    //PERINTAH POST
    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody BankAccount bankAccount, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ErrorMessage> validationErrors = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                ErrorMessage errorMessage = new ErrorMessage();
                errorMessage.setCode("VALIDATION_ERROR");
                errorMessage.setMessage(error.getDefaultMessage());
                validationErrors.add(errorMessage);
            }
            return ResponseEntity.badRequest().body(validationErrors);
        }

        BankAccount createdBankAccount = bankAccountService.createOrUpdateAccount(bankAccount);
        return ResponseEntity.ok(createdBankAccount);
    }

    //PERINTAH GET
    @GetMapping
    public List<BankAccount> getAllBankAccount(){
        return bankAccountService.getAllAccount();
    }

    //GET By IDx
    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getBankAccountById(@PathVariable String id){
        Optional<BankAccount> product = bankAccountService.getAccountById(id);
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //PERINTAH PUT
    @PutMapping("/{id}")
    public BankAccount updateAccount(@PathVariable String id, @RequestBody BankAccount bankAccount){
        bankAccount.setId(id);
        return bankAccountService.createOrUpdateAccount(bankAccount);
    }

    //PERINTAH DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountById(@PathVariable String id){
        bankAccountService.deleteAccountById(id);
        return ResponseEntity.notFound().build();
    }
}
