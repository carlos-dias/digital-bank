package br.com.carlosdias.digitalbank.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "account")
@Data
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "account_seq", allocationSize = 1)
    private Long id;
    private Long balance;
    private String name;
}
