package com.project.payment.payments.controllers;

import com.project.payment.payments.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    private TransactionService transactionService;

    @Autowired
    TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping("/transactions/transaction")
    public ResponseEntity<String> createTransaction(@RequestBody String str){
        String res = str+" added something";
        System.out.println(res);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
