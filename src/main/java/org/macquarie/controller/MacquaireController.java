package org.macquarie.controller;

import org.macquarie.constants.MacquarieConstants;
import org.macquarie.exceptions.MacquaireException;
import org.macquarie.model.Account;
import org.macquarie.model.Transaction;
import org.macquarie.services.AccountListService;
import org.macquarie.services.TransactionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/macquaire")
public class MacquaireController {

    @Autowired
    private AccountListService accountListService;

    @Autowired
    private TransactionListService transactionListService;

    @GetMapping("accounts/{userId}")
    public ResponseEntity<List<Account>> getAccountList(@PathVariable String userId,
                                                        @RequestHeader (value = MacquarieConstants.TRACE_ID, required = true) String traceId) throws MacquaireException {

        List<Account> accountLists = accountListService.getAccountList(userId);
        return  new ResponseEntity<>(accountLists, HttpStatus.OK);
    }

    @GetMapping("transactions/{accountNumber}")
    public ResponseEntity<List<Transaction>> getTransactionList(@PathVariable String accountNumber,
                                                                @RequestHeader (value = MacquarieConstants.TRACE_ID, required = true) String traceId ) throws MacquaireException {

        List<Transaction> transactionList = transactionListService.getTransactionList(accountNumber);
        return  new ResponseEntity<>(transactionList, HttpStatus.OK);
    }

}
