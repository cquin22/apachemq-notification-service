package com.notification.service.repository;

import com.notification.service.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction findByTransactionCode(Integer transactionCode);
}
