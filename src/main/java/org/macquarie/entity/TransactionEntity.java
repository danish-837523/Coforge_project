package org.macquarie.entity;

import lombok.Getter;
import lombok.Setter;
import org.macquarie.model.Currency;

import javax.persistence.*;
import java.math.BigDecimal;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "TransactionList")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountNumber;
    private String accountName;
    private Date valueDate;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    private String transactionType;
    private String transactionNarrative;

}
