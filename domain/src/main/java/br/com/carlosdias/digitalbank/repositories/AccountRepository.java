package br.com.carlosdias.digitalbank.repositories;

import br.com.carlosdias.digitalbank.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    @Modifying
    @Query("UPDATE AccountEntity a SET a.balance = a.balance + :amount WHERE a.id = :id")
    int credit(@Param("id") Long id, @Param("amount") Long amount);

    @Modifying
    @Query("UPDATE AccountEntity a SET a.balance = a.balance - :amount WHERE a.id = :id AND a.balance >= :amount")
    int debit(@Param("id") Long id, @Param("amount") Long amount);
}
