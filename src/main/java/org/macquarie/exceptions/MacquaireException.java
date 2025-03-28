package org.macquarie.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MacquaireException extends Exception{

    private String code;
    private String message;
    private int httpStatus;

}
