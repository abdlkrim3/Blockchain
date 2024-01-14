package com.blockchain.blockchainworkshop.helper;

import com.blockchain.blockchainworkshop.entity.Block;
import com.blockchain.blockchainworkshop.entity.Blockchain;
import com.blockchain.blockchainworkshop.entity.Transaction;
import com.blockchain.blockchainworkshop.entity.TransactionPool;
import org.junit.jupiter.api.Test;

class BlockchainTest {

    @Test
    public void mainTest() {
        // Create a blockchain with difficulty level 2
        Blockchain blockchain = new Blockchain(2);

        // Create a transaction pool
        TransactionPool transactionPool = blockchain.getTransactionPool();

        // Create some sample transactions
        Transaction transaction1 = new Transaction("Alice", "Bob", 10);
        Transaction transaction2 = new Transaction("Bob", "Charlie", 5);
        Transaction transaction3 = new Transaction("Charlie", "Alice", 3);

        // Add the transactions to the transaction pool
        transactionPool.addTransaction(transaction1);
        transactionPool.addTransaction(transaction2);
        transactionPool.addTransaction(transaction3);

        // Mine a new block
        Block block = blockchain.mineBlock();


        // Display the mined block
        System.out.println("Mined Block:");
        System.out.println(block);

        // Display the updated blockchain
        System.out.println("Blockchain:");
        for (Block b : blockchain.getChain()) {
            System.out.println(b);
        }


    }
}