package org.macquarie.model;

public enum AccountType {

    Savings("Savings","Savings"),
    Current("Current","Current");



    private final String code;
    private final String value;

    AccountType(String code,String value){
        this.code=code;
        this.value=value;

    }
    public String getCode(){
        return code;
    }
    public String getValue(){
        return value;
    }

    public static AccountType convertAccountType(String accountType) {
        for (AccountType account : values()) {
            if (account.getCode().equals(accountType)) {
                return account;
            }
        }
        throw new IllegalArgumentException("Invalid Account Type: " + accountType);
    }

}
