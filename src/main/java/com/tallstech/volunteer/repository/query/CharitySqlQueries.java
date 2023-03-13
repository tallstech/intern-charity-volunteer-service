package com.tallstech.volunteer.repository.query;

public class CharitySqlQueries {
    private CharitySqlQueries(){}

    public static final String SQL_FETCH_CHARITY = "SELECT charity FROM public.charities ORDER BY charity ASC";
    public static final String SQL_INSERT_CHARITY = "INSERT INTO charities (charity, city, district, address, phone_number, fax, call_center)\n" +
            "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
}
