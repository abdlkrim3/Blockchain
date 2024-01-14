package com.blockchain.blockchainworkshop.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {

    private final String sender;

    private final String recipient;

    private final double amount;

    private String signature;

    public Transaction(String sender, String recipient, double amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.signature = ""; // Placeholder for digital signature
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", amount=" + amount +
                ", signature='" + signature + '\'' +
                '}';
    }

}
