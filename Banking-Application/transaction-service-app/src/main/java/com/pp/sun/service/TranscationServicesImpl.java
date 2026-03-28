package com.pp.sun.service;

import com.pp.sun.dto.AccountResponse;
import com.pp.sun.dto.TransactionResponse;
import com.pp.sun.dto.TransctionRequest;
import com.pp.sun.entiry.Transaction;
import com.pp.sun.entiry.emum.TransactionType;
import com.pp.sun.exception.DuplicateTransectionException;
import com.pp.sun.feign.AccountFeignClient;
import com.pp.sun.mapper.TransactionMapper;
import com.pp.sun.repositrory.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@AllArgsConstructor
public class TranscationServicesImpl implements TransactionServices {

    private TransactionRepository transactionRepository;

    private AccountFeignClient accountFeignController;


    @Override
    public void deposit(TransctionRequest transctionRequest) throws Throwable {

        transactionRepository.findByReferenceId(transctionRequest.refrenceId())
                .ifPresent(
                        trans -> {
                            throw new DuplicateTransectionException("Duplicate Transection For " + trans.getReferenceId() + "...!");
                        });

        AccountResponse accountResponse = accountFeignController.depositAmount(transctionRequest.accountNumber(), transctionRequest.amount());

        TransactionResponse transactionResponse = TransactionMapper.transcectionEntityToDtoMapper(transactionRepository.save(new Transaction(
                transctionRequest.accountNumber(),
                TransactionType.CREDIT,
                transctionRequest.amount(),
                transctionRequest.refrenceId()
        )));


    }

    @Override
    public void withdraw(TransctionRequest transctionRequest) throws Throwable {
        transactionRepository.findByReferenceId(transctionRequest.refrenceId())
                .ifPresent(
                        trans -> {
                            throw new DuplicateTransectionException("Duplicate Transection For " + trans.getReferenceId() + "...!");
                        });

        AccountResponse accountResponse = accountFeignController.withdrawAmount(transctionRequest.accountNumber(), transctionRequest.amount());

        TransactionResponse transactionResponse = TransactionMapper.transcectionEntityToDtoMapper(transactionRepository.save(new Transaction(
                transctionRequest.accountNumber(),
                TransactionType.DEBIT,
                transctionRequest.amount(),
                transctionRequest.refrenceId()
        )));
    }
}
