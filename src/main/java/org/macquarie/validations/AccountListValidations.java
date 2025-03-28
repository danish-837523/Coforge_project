package org.macquarie.validations;

import lombok.extern.slf4j.Slf4j;
import org.macquarie.constants.LogConstants;
import org.macquarie.exceptions.MacquaireException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AccountListValidations {


    public boolean validateUserId(String userId) throws MacquaireException {

        if (!userId.matches("^\\d+$")) {
            log.error(LogConstants.INVALID_USER.getMessage());
            throw new MacquaireException(LogConstants.INVALID_USER.getCode(),LogConstants.INVALID_USER.getMessage(), HttpStatus.BAD_REQUEST.value());
        }
        else
        return userId.matches("^\\d+$");
    }
}
