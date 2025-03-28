package org.macquarie.dataloader;

import org.macquarie.entity.AccountEntity;
import org.macquarie.entity.TransactionEntity;
import org.macquarie.model.AccountType;
import org.macquarie.model.Currency;
import org.macquarie.repostories.AccountListRepository;
import org.macquarie.repostories.TransactionListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class DataLoader {

    @Autowired
    private AccountListRepository accountListRepository;

    @Autowired
    private TransactionListRepository transactionListRepository ;

    @PostConstruct
    public void loadData() {
        AccountEntity account1 = new AccountEntity();
        account1.setUserId(1L);
        account1.setAccountNumber(1234567890L);
        account1.setAccountName("John Doe Savings");
        account1.setAccountType(AccountType.Savings);
        account1.setCurrency(Currency.AUD);
        account1.setBalanceDate(new Date());
        account1.setOpeningAvailableBalance(new BigDecimal("5000.00"));
        accountListRepository.save(account1);

        TransactionEntity transaction1 = new TransactionEntity();
        transaction1.setAccountNumber(1234567890L);
        transaction1.setAccountName("John Doe Savings");
        transaction1.setValueDate(new Date());
        transaction1.setCurrency(Currency.AUD);
        transaction1.setDebitAmount(new BigDecimal("0.00"));
        transaction1.setCreditAmount(new BigDecimal("100.00"));
        transaction1.setTransactionType("Credit");
        transaction1.setTransactionNarrative("");
        transactionListRepository.save(transaction1);
    }
}
