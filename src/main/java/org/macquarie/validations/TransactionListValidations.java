package org.macquarie.validations;

import lombok.extern.slf4j.Slf4j;
import org.macquarie.constants.LogConstants;
import org.macquarie.exceptions.MacquaireException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TransactionListValidations {



    public boolean validateAccountNumber(String userId) throws MacquaireException {

        boolean isValid = false;
        if (!userId.matches("^\\d+$")) {
            log.error(LogConstants.INVALID_ACCOUNT_NUMBER.getMessage());
            throw new MacquaireException(LogConstants.INVALID_ACCOUNT_NUMBER.getCode(), LogConstants.INVALID_ACCOUNT_NUMBER.getMessage(), HttpStatus.BAD_REQUEST.value());
        }
        else
            isValid= userId.matches("^\\d+$");

        if(userId.length()!=10){
            log.error(LogConstants.INVALID_ACCOUNT_NUMBER_LENGTH.getMessage());
            throw new MacquaireException(LogConstants.INVALID_ACCOUNT_NUMBER_LENGTH.getCode(),LogConstants.INVALID_ACCOUNT_NUMBER_LENGTH.getMessage(), HttpStatus.BAD_REQUEST.value());
        }
        return isValid;
    }

}
