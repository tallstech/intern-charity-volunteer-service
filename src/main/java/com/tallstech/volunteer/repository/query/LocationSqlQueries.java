package com.tallstech.volunteer.repository.query;

public class LocationSqlQueries {
    private LocationSqlQueries(){}

    public static final String SQL_FETCH_CITIES = "SELECT DISTINCT city FROM public.locations ORDER BY city ASC";
    public static final String SQL_FETCH_DISTRICTS = "SELECT DISTINCT district FROM public.locations WHERE city ILIKE ? ORDER BY district ASC";
    public static final String SQL_FETCH_TOWNS = "SELECT DISTINCT town FROM public.locations WHERE city ILIKE ?  AND district ILIKE  ?  ORDER BY town ASC";
    public static final String SQL_FETCH_NEIGHBORHOODS_WITH_TOWN = "SELECT DISTINCT neighborhood FROM public.locations WHERE city ILIKE ?  AND district ILIKE ?  AND town ILIKE ?  ORDER BY neighborhood ASC";
    public static final String SQL_FETCH_NEIGHBORHOODS_WITH_ZIP_CODE = "SELECT DISTINCT neighborhood FROM public.locations WHERE city ILIKE ?  AND district ILIKE ?  AND town ILIKE ? AND zip_code ILIKE ?  ORDER BY neighborhood ASC";




}
