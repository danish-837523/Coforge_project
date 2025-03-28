package org.macquarie.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Getter
@Setter
@Component
public class Transaction {


    private Long accountNumber;
    private String accountName;
    private String valueDate;
    private String currency;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    private String transactionType;
    private String transactionNarrative;
}
