package org.macquarie.services;


import org.macquarie.entity.AccountEntity;
import org.macquarie.exceptions.MacquaireException;
import org.macquarie.model.Account;
import org.macquarie.repostories.AccountListRepository;
import org.macquarie.utils.DateFormats;
import org.macquarie.validations.AccountListValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountListService {

    @Autowired
    private AccountListRepository accountListRepository;

    @Autowired
    private AccountListValidations accountListValidations;

    public List<Account> getAccountList(String userId) throws MacquaireException {

        boolean isValidUser = accountListValidations.validateUserId(userId);
        List<Account> accountsList = new ArrayList<>();
        if (isValidUser) {
            List<AccountEntity>  list = accountListRepository.findByUserId(Long.parseLong(userId));
           accountsList = list.stream().map(entity -> {
                Account account = new Account();
                account.setAccountNumber(entity.getAccountNumber());
                account.setAccountName(entity.getAccountName());
                account.setAccountType(entity.getAccountType().getValue());
                account.setBalanceDate(DateFormats.formattedDate(entity.getBalanceDate()));
                account.setCurrency(entity.getCurrency().getValue());
                account.setOpeningAvailableBalance(entity.getOpeningAvailableBalance());
                return account;
            }).toList();

        }
        return accountsList;
    }
}
