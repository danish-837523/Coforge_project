package org.macquarie.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Setter
@Component
public class Account {

    private Long accountNumber;
    private String accountName;
    private String accountType;
    private String balanceDate;
    private String currency;
    private BigDecimal openingAvailableBalance;
}
