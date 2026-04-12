package br.com.carlosdias.digitalbank.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity(name = "account")
public class AccountEntity {

    @Id
    private Long id;

    private BigDecimal balance;
}
