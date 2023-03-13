package com.tallstech.volunteer.constant;

public enum WorkTypes {
    WORK("work");

    private String label;

    WorkTypes(String label){this.label = label;}
    public String label(){return this.label;}
}
