package org.macquarie.services;

import org.macquarie.entity.TransactionEntity;
import org.macquarie.exceptions.MacquaireException;
import org.macquarie.model.Currency;
import org.macquarie.model.Transaction;
import org.macquarie.repostories.TransactionListRepository;
import org.macquarie.utils.DateFormats;
import org.macquarie.validations.TransactionListValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionListService {

    @Autowired
    private TransactionListRepository transactionListRepository;

    @Autowired
    private TransactionListValidations transactionListValidations;

    public List<Transaction> getTransactionList(String accountNumber) throws MacquaireException {

        boolean isValidAccountNumber = transactionListValidations.validateAccountNumber(accountNumber);
        List<Transaction> transactionList = new ArrayList<>();
        if(isValidAccountNumber){
            List<TransactionEntity> list = transactionListRepository.findByaccountNumber(Long.parseLong(accountNumber));
            transactionList = list.stream().map(entity->{
                Transaction transaction = new Transaction();
                transaction.setAccountNumber(entity.getAccountNumber());
                transaction.setAccountName(entity.getAccountName());
                transaction.setValueDate(DateFormats.formatDate(entity.getValueDate()));
                transaction.setCurrency(entity.getCurrency().getValue());
                transaction.setDebitAmount(entity.getDebitAmount());
                transaction.setCreditAmount(entity.getCreditAmount());
                transaction.setTransactionType(entity.getTransactionType());
                transaction.setTransactionNarrative(entity.getTransactionNarrative());
                return transaction;
            }).toList();

        }
        return transactionList;
    }
}
