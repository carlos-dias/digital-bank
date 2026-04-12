package br.com.carlosdias.digitalbank.repositories;

import br.com.carlosdias.digitalbank.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
