package com.tallstech.volunteer.service;

import com.tallstech.volunteer.model.Work;
import com.tallstech.volunteer.repository.WorkRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class WorkService {

    private WorkRepository workRepository;

    public WorkService(WorkRepository workRepository){this.workRepository = workRepository;}

    public List<Work> getClickableWorks(String charity,String work) throws Exception{
        List<Work> works;
        if(ObjectUtils.isEmpty(charity)) {
            works = getClickableWorks();
        }
        else{
            log.error("An exception occurred while fetching works.");
            throw new RuntimeException("An exception occurred while fetching works.");
        }
        return works;
    }

    private List<Work> getClickableWorks(){return workRepository.fetchWorks();}
}
