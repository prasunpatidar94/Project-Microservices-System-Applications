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
@RequestMapping(path = "v1/transection")
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRestController {

    private TransactionServices transcationServices;

    @PostMapping(path = "/deposit")
    public ResponseEntity<Void> deposit(@RequestBody TransctionRequest transctionRequest) {
        transcationServices.deposit(transctionRequest);
       return ResponseEntity.ok().build();
    }
    @PostMapping(path = "/withdraw")
    public ResponseEntity<Void> withdraw(@RequestBody TransctionRequest transctionRequest) {
        transcationServices.withdraw(transctionRequest);
        return ResponseEntity.ok().build();
    }


}
