package ma.enset.blockchainspringboot.web;
import ma.enset.blockchainspringboot.entities.Block;
import ma.enset.blockchainspringboot.entities.Blockchain;
import ma.enset.blockchainspringboot.entities.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blockchain")
public class BlockChainRestController {
    private Blockchain blockchain;

    public BlockChainRestController() {
        this.blockchain = new Blockchain(3, 10);
    }

    @GetMapping("/blocks")
    public List<Block> getBlocks() {
        return blockchain.getChain();
    }

    @PostMapping("/transactions")
    public void addTransaction(@RequestBody Transaction transaction) {
        blockchain.getTransactionPool().addTransaction(transaction);
    }

    @PostMapping("/mine")
    public void mineBlock() {
        Block newBlock = new Block(blockchain.getLatestBlock().getIndex() + 1, "", "");
        blockchain.addBlock(newBlock);
    }
}
