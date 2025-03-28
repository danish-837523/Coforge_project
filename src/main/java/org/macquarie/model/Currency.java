package org.macquarie.model;

public enum Currency {
    AUD("AUD","AUD"),
    SGD("AUD","SGD");

    private final String code;
    private final String value;

    Currency(String code,String value){
        this.code=code;
        this.value=value;

    }
    public String getCode(){
        return code;
    }
    public String getValue(){
        return value;
    }

    public static Currency convertCurrency(String currencyCode) {
        for (Currency currency : values()) {
            if (currency.getCode().equals(currencyCode)) {
                return currency;
            }
        }
        throw new IllegalArgumentException("Invalid Currency code: " + currencyCode);
    }

}
