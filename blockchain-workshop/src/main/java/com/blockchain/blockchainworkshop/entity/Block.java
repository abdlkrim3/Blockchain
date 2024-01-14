package com.blockchain.blockchainworkshop.entity;

import com.blockchain.blockchainworkshop.helper.HashUtil;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class Block {

    private int index;

    private Instant timestamp;

    private String previousHash;

    private String currentHash;

    private List<Transaction> transactions;

    private int nonce;

    public Block(int index, String previousHash, List<Transaction> transactions, int nonce) {
        this.index = index;
        this.timestamp = Instant.now();
        this.previousHash = previousHash;
        this.transactions = transactions;
        this.nonce = nonce;
        this.currentHash = calculateHash();
    }

    public void incrementNonce() {
        nonce++;
    }

    public String calculateHash() {
        // Hash calculation logic using the block's attributes and HashUtil
        // Example implementation:
        String data = index + timestamp.toString() + previousHash + transactions.toString() + nonce;
        return HashUtil.calculateSHA256(data);
    }


}
