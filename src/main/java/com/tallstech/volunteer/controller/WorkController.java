package com.tallstech.volunteer.controller;

import com.tallstech.volunteer.model.Work;
import com.tallstech.volunteer.service.WorkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class WorkController implements WorkApi {

    private WorkService workService;

    public WorkController(WorkService workService){this.workService=workService;}

    @Override
    public ResponseEntity<List<Work>> getWorks(Map<String, String>header, String charity, String work) throws Exception{
        return ResponseEntity.ok(workService.getClickableWorks(charity, work));
    }
}
