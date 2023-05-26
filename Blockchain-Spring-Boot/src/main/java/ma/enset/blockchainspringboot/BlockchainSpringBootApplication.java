package ma.enset.blockchainspringboot;

import lombok.Builder;
import lombok.Data;
import ma.enset.blockchainspringboot.entities.Block;
import ma.enset.blockchainspringboot.entities.Blockchain;
import ma.enset.blockchainspringboot.repositories.BlockRepository;
import ma.enset.blockchainspringboot.repositories.BlockchainRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@Data@Builder
@SpringBootApplication
public class BlockchainSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlockchainSpringBootApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BlockRepository blockRepository, BlockchainRepository blockchainRepository){
		return args -> {
			Block block1=new Block(1,"00000RTEDFDGRTRETET64TRET","Hello, World");
			Block block2=new Block(2,"00000RTEDFDGHFD643TE4TRET","Hello");
			Block block3=new Block(3,"00000RT6543RRDGRER65RTRET","World");
			Blockchain blockchain=new Blockchain(4,10);
			blockchain.addBlock(block1);
			blockchain.addBlock(block2);
			blockchain.addBlock(block3);
			blockchain.getChain();
			blockchain.getLatestBlock();
			blockchain.mineBlock(block2,5);
		};
	}
}
