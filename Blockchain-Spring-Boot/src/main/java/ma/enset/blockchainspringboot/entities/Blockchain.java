package ma.enset.blockchainspringboot.entities;
import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private Long id;
    private List<Block> chain;
    private TransactionPool transactionPool;
    private int difficulty;
    private int difficultyAdjustmentInterval;

    public Blockchain(int difficulty, int difficultyAdjustmentInterval) {
        this.chain = new ArrayList<>();
        this.transactionPool = new TransactionPool();
        this.difficulty = difficulty;
        this.difficultyAdjustmentInterval = difficultyAdjustmentInterval;
        createGenesisBlock();
    }

    public void createGenesisBlock() {
        Block genesisBlock = new Block(0, "0", "Genesis Block");
        chain.add(genesisBlock);
    }

    public void addBlock(Block block) {
        block.setIndex(chain.size());
        block.setPreviousHash(getLatestBlock().getCurrentHash());

        // Mine the block
        mineBlock(block, difficulty);

        chain.add(block);
        transactionPool.getPendingTransactions().clear();
        adjustDifficulty();
    }

    public void mineBlock(Block block, int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!block.getCurrentHash().substring(0, difficulty).equals(target)) {
            block.incrementNonce();
            block.generateBlock();
        }
        System.out.println("Block mined: " + block.getCurrentHash());
    }

    public void adjustDifficulty() {
        if (chain.size() % difficultyAdjustmentInterval == 0) {
            long timeTaken = chain.get(chain.size() - 1).getTimestamp() - chain.get(chain.size() - difficultyAdjustmentInterval).getTimestamp();
            if (timeTaken < difficultyAdjustmentInterval) {
                difficulty++;
            } else {
                difficulty--;
            }
        }
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public TransactionPool getTransactionPool() {
        return transactionPool;
    }

    public List<Block> getChain() {
        return chain;
    }
}
