package ma.enset.blockchainspringboot.entities;
import java.util.ArrayList;
import java.util.List;

public class TransactionPool {
    private List<Transaction> pendingTransactions;

    public TransactionPool() {
        this.pendingTransactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        pendingTransactions.add(transaction);
    }

    public void removeTransaction(Transaction transaction) {
        pendingTransactions.remove(transaction);
    }

    public List<Transaction> getPendingTransactions() {
        return pendingTransactions;
    }
}
