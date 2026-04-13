package br.com.carlosdias.digitalbank.repositories;

import br.com.carlosdias.digitalbank.entities.TransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    Page<TransactionEntity> findByAccountIdOrderByCreatedAtDesc(Long accountId, Pageable pageable);
}