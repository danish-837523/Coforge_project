package org.macquarie.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;



@Getter
@Setter
@Component
@NoArgsConstructor
public class ErrorResponse {

    private String code;
    private String message;
    private String traceId;
    private int status;

}
