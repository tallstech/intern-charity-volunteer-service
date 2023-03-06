package com.tallstech.volunteer.repository;

import static com.tallstech.volunteer.constant.LocationConstants.LOCATION_JDBC_TEMPLATE;
import static com.tallstech.volunteer.repository.query.LocationSqlQueries.SQL_FETCH_CITIES;
import static com.tallstech.volunteer.repository.query.LocationSqlQueries.SQL_FETCH_DISTRICTS;
import static com.tallstech.volunteer.repository.query.LocationSqlQueries.SQL_FETCH_NEIGHBORHOODS_WITH_TOWN;
import static com.tallstech.volunteer.repository.query.LocationSqlQueries.SQL_FETCH_TOWNS;

import java.util.List;

import com.tallstech.volunteer.constant.LocationTypes;
import com.tallstech.volunteer.model.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Slf4j
@Repository
public class LocationRepository {

    private final JdbcTemplate locationJdbcTemplate;

    public LocationRepository(@Qualifier(LOCATION_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.locationJdbcTemplate = jdbcTemplate;
    }

    public List<Location> fetchCities() {
        List<Location> cities = null;
        try {
            cities = locationJdbcTemplate.query(SQL_FETCH_CITIES, (rs, rowNum) -> new Location(
                    LocationTypes.CITY.label(),
                    rs.getString("city")
            ));
        } catch (Exception exception) {
            log.error("An exception occurred while fetching cities");
        }
        return cities;
    }

    public List<Location> fetchClickableDistricts(String city) throws Exception {
        List<Location> districts;
        try {
            String cityParameter = "%"+city.toUpperCase()+"%";
            districts = locationJdbcTemplate.query(SQL_FETCH_DISTRICTS, (rs, rowNum) -> new Location(
                    LocationTypes.DISTRICT.label(),
                    rs.getString("district")

            ), new Object[]{cityParameter});
        } catch (Exception exception) {
            log.error("An exception occurred while fetching districts");
            throw new RuntimeException("An exception occurred while fetching districts", exception);
        }
        return districts;
    }

    public List<Location> fetchClickableTowns(String city, String district) {
        List<Location> towns;
        try {
            String cityParameter = "%"+city.toUpperCase()+"%";
            String districtParameter = "%"+district.toUpperCase()+"%";
            towns = locationJdbcTemplate.query(SQL_FETCH_TOWNS, (rs, rowNum) -> new Location(
                    LocationTypes.TOWN.label(),
                    rs.getString("town")

            ), new Object[]{cityParameter, districtParameter});

        } catch (Exception exception) {
            log.error("An exception occurred while fetching towns");
            throw new RuntimeException("An exception occurred while fetching towns", exception);
        }
        return towns;
    }

    public List<Location> fetchClickableNeighborhoods(String city, String district, String town) {
        List<Location> neighborhoods;
        try {
            String cityParameter = "%"+city.toUpperCase()+"%";
            String districtParameter = "%"+district.toUpperCase()+"%";
            String townParameter = "%"+town.toUpperCase()+"%";
            neighborhoods = locationJdbcTemplate.query(SQL_FETCH_NEIGHBORHOODS_WITH_TOWN, (rs, rowNum) -> new Location(
                            LocationTypes.NEIGHBORHOOD.label(),
                            rs.getString("neighborhood")

                    ), new Object[]{cityParameter, districtParameter, townParameter}
            );

        } catch (Exception exception) {
            log.error("An exception occurred while fetching neighborhoods");
            throw new RuntimeException("An exception occurred while fetching neighborhoods", exception);
        }
        return neighborhoods;
    }

}
