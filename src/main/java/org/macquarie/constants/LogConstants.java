package org.macquarie.constants;

public enum LogConstants {

    INVALID_USER("MAC_001", "User Id is invalid. It should be numeric"),
    INVALID_ACCOUNT_NUMBER("MAC_002", "Account Number is invalid."),
    INVALID_ACCOUNT_NUMBER_LENGTH("MAC_003", "Lenth of Account Number is invalid. It should be 10 digits."),
    INTERNAL_SERVER_ERROR("MAC_500", "Internal server error occurred"),
    MANDATORY_HEADER_MISSING("MAC_004", "Header Missing or invalid");


    private final String code;
    private final String message;

    LogConstants(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
