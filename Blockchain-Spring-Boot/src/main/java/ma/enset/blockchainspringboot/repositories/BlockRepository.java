package ma.enset.blockchainspringboot.repositories;

import ma.enset.blockchainspringboot.entities.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block,Integer> {
}
