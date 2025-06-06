package com.utk.service;

import com.utk.entity.TransactionDao;
import com.utk.repository.TransactionRepo;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepo transactionRepo;

    public TransactionService(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public TransactionDao saveTransaction(TransactionDao transactionDao){
        return transactionRepo.save(transactionDao);
    }

}
