package com.tallstech.volunteer.constant;

public enum CharityTypes {
    CHARITY("charity"),
    CITY("city"),
    DISTRICT("district"),
    ADDRESS("address"),
    PHONE_NUMBER("phone_number"),
    FAX("fax"),
    CALL_CENTER("call_center");
    private String label;

    CharityTypes(String label){
        this.label = label;
    }

    public String label() {
        return this.label;
    }
}
