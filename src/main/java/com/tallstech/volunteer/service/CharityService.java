package com.tallstech.volunteer.service;

import com.tallstech.volunteer.model.Charity;
import com.tallstech.volunteer.model.Location;
import com.tallstech.volunteer.repository.CharityRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class CharityService {
    private CharityRepository charityRepository;

    public CharityService(CharityRepository charityRepository) {
        this.charityRepository = charityRepository;
    }

    public List<Charity> getClickableCharities(String charity) throws Exception {
        List<Charity> charities;
        if (ObjectUtils.isEmpty(charity)) {
            charities = getClickableCharities();
        } else {
            log.error("An exception occurred while fetching ");
            throw new RuntimeException("An exception occurred while fetching ");
        }
        return charities;
    }
   /* public void charityForm (String charity,  String admin_name, String admin_surname, String admin_tckn, String admin_email,
                             String admin_password, String admin_phone_number) {
        charityRepository.insert();
    }*/

    private List<Charity> getClickableCharities() {
        return charityRepository.fetchCharities();
    }

}
