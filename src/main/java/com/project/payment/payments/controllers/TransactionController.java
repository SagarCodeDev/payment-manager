package com.project.payment.payments.controllers;

import com.project.payment.payments.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.project.payment.payments.Constants.PAYMENT_APP_BASE_PATH;

@RestController
@RequestMapping(PAYMENT_APP_BASE_PATH + "/transactions")
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
