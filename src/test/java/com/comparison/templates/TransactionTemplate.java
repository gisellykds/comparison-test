package com.comparison.templates;

import com.comparison.model.Transaction;

public class TransactionTemplate {

    public static Transaction getTransaction(){
        Transaction transaction = new Transaction();
        transaction.setPid(123);
        transaction.setPamount(94.7);
        transaction.setPdata(20160101120000L);
        return transaction;
    }
}
