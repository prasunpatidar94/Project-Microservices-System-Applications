package com.pp.sun.service;

import com.pp.sun.dto.TransctionRequest;
import com.pp.sun.repositrory.TransctionRepository;
import com.pp.sun.exception.DuplicateTransectionException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@NoArgsConstructor
@AllArgsConstructor
public class TranscationServicesImpl implements TransactionServices {
    private TransctionRepository transctionRepository;


    @Override
    public void deposit(TransctionRequest transctionRequest) {

        transctionRepository.findByReferenceId(transctionRequest.refrenceId())
                .ifPresent(
                        trans -> {
                            throw new DuplicateTransectionException(STR."Duplicate Transection For \{trans.getReferenceId()}...!");
                        });

        

    }

    @Override
    public void withdraw(TransctionRequest transctionRequest) {

    }
}
