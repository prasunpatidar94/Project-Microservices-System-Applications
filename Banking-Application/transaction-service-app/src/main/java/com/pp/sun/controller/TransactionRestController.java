package com.pp.sun.controller;


import com.pp.sun.dto.TransctionRequest;
import com.pp.sun.service.TransactionServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/transaction")
@AllArgsConstructor
public class TransactionRestController {

    private TransactionServices transactionServices;

    @PostMapping(path = "/deposit")
    public ResponseEntity<Void> deposit(@RequestBody TransctionRequest transctionRequest) throws Throwable {
        transactionServices.deposit(transctionRequest);
       return ResponseEntity.ok().build();
    }
    @PostMapping(path = "/withdraw")
    public ResponseEntity<Void> withdraw(@RequestBody TransctionRequest transctionRequest) throws Throwable {
        transactionServices.withdraw(transctionRequest);
        return ResponseEntity.ok().build();
    }


}
