package ma.enset.blockchainspringboot.repositories;

import ma.enset.blockchainspringboot.entities.Blockchain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockchainRepository extends JpaRepository<Blockchain,Integer> {
}
