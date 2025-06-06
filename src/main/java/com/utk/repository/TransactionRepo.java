package com.utk.repository;

import com.utk.entity.TransactionDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<TransactionDao,Long> {
}
