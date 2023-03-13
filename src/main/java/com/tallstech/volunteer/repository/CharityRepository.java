package com.tallstech.volunteer.repository;

import com.tallstech.volunteer.constant.CharityTypes;
import com.tallstech.volunteer.constant.LocationTypes;
import com.tallstech.volunteer.model.Charity;
import com.tallstech.volunteer.model.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.tallstech.volunteer.constant.VolunteerConstants.VOLUNTEER_JDBC_TEMPLATE;
import static com.tallstech.volunteer.repository.query.CharitySqlQueries.*;
@Slf4j
@Repository
public class CharityRepository {
    private final JdbcTemplate charityJdbcTemplate;

    public CharityRepository(@Qualifier(VOLUNTEER_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.charityJdbcTemplate = jdbcTemplate;
    }

    public List<Charity> fetchCharities() {
        List<Charity> charities = null;
        try {
            charities = charityJdbcTemplate.query(SQL_FETCH_CHARITY, (rs, rowNum) -> new Charity(
                    CharityTypes.CHARITY.label(),
                    rs.getString("charity")
            ));
        } catch (Exception exception) {
            log.error("An exception occurred while fetching charities");
        }
        return charities;
    }

    public void insertCharity(String charity,  String city, String district, String address, String phone_number,
                       String fax, String call_center) {
        try{
            charityJdbcTemplate.update(SQL_INSERT_CHARITY, charity, city, district, address, phone_number, fax, call_center);
        }
        catch (Exception exception){
            log.error("An exception occurred while updating charities");
        }
    }
}
