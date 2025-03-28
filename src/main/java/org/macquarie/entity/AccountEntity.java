package org.macquarie.entity;

import lombok.Getter;
import lombok.Setter;
import org.macquarie.model.AccountType;
import org.macquarie.model.Currency;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "AccountList")
public class AccountEntity {


    private Long userId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;
    private String accountName;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Date balanceDate;

    @Enumerated(EnumType.STRING)
    private Currency currency;
    private BigDecimal openingAvailableBalance;



}
