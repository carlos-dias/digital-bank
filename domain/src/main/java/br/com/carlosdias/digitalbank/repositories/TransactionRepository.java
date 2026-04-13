package br.com.carlosdias.digitalbank.repositories;

import br.com.carlosdias.digitalbank.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
}