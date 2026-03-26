package com.pp.sun.service;

import com.pp.sun.dto.TransctionRequest;
import org.springframework.stereotype.Service;

@Service

public interface TransactionServices {
      void deposit(TransctionRequest transctionRequest);
      void withdraw(TransctionRequest transctionRequest);
}
