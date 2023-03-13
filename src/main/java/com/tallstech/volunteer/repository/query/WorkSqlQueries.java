package com.tallstech.volunteer.repository.query;

public class WorkSqlQueries {
    private WorkSqlQueries(){}

    public static  final String SQL_FETCH_WORKS = "SELECT DISTINCT work FROM public.neededvolunteer ORDER BY work ASC";
}

