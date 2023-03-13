package com.tallstech.volunteer.repository;


import com.tallstech.volunteer.constant.WorkTypes;
import com.tallstech.volunteer.model.Work;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.tallstech.volunteer.constant.VolunteerConstants.VOLUNTEER_JDBC_TEMPLATE;
import static com.tallstech.volunteer.constant.WorkConstants.WORK_JDBC_TEMPLATE;
import static com.tallstech.volunteer.repository.query.WorkSqlQueries.*;

@Slf4j
@Repository
public class WorkRepository {

    private final JdbcTemplate workJdbcTemplate;

    public WorkRepository(@Qualifier(VOLUNTEER_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate){
        this.workJdbcTemplate =jdbcTemplate;
    }

    public List<Work> fetchWorks(){
        List<Work> works = null;
        try{
            works = workJdbcTemplate.query(SQL_FETCH_WORKS, (rs, rowNum) -> new Work(
                    WorkTypes.WORK.label(),
                    rs.getString("work")
            ));
        }
        catch (Exception exception){
            log.error("An exception occurred while fetching works");
        }
        return works;
    }
}
