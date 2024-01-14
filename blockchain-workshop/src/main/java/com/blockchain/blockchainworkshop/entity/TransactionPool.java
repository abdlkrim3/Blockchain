package com.blockchain.blockchainworkshop.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TransactionPool {

    private final List<Transaction> pendingTransactions;

    public TransactionPool() {
        this.pendingTransactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        pendingTransactions.add(transaction);
    }

    public List<Transaction> getPendingTransactions() {
        return pendingTransactions;
    }

    public void removeTransaction(Transaction transaction) {
        pendingTransactions.remove(transaction);
    }

    public void removeTransactions(List<Transaction> transactions) {
        pendingTransactions.removeAll(transactions);
    }

}
