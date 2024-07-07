package com.example.factory;

import com.example.dao.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionFactory {

    public static Transaction aTransactionWithId () {
        BigDecimal transactionAmount = new BigDecimal("123.23");
        BigDecimal balanceBefore = new BigDecimal("2.43");
        BigDecimal balanceAfter = new BigDecimal("3.32");

        return new Transaction(2L, LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), transactionAmount, balanceBefore, balanceAfter);
    }
}
