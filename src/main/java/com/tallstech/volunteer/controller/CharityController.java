package com.tallstech.volunteer.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import com.tallstech.volunteer.model.Charity;
import com.tallstech.volunteer.service.CharityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharityController implements CharityApi{
    private CharityService charityService;

    public CharityController(CharityService charityService){
        this.charityService = charityService;
    }
    @Override
    public ResponseEntity<List<Charity>> getCharities (Map<String, String> header, String charity) throws Exception {
        return ResponseEntity.ok(charityService.getClickableCharities(charity));
    }

    /*@Override
    public ResponseEntity createCharity(String charity,  String admin_name, String admin_surname, String admin_tckn, String admin_email,
                                        String admin_password, String admin_phone_number) throws URISyntaxException {
       return ResponseEntity.ok(charityService.charityForm(charity, admin_name, admin_surname, admin_tckn, admin_email, admin_password, admin_phone_number));
    }

    @PostMapping(consumes = {"application/json;charset=utf-8"}, produces = {"application/json;charset=utf-8"})
    public ResponseEntity createCharity(@RequestBody Charity charity) throws URISyntaxException {
        System.out.println("Charity created :: "+charity);
        return new ResponseEntity(charity, HttpStatus.CREATED);
    }

    @GetMapping(produces = {"application/json;charset=utf-8"})
    public List<Charity> getCharities(){
        Charity charity1 = new Charity(1,"IHH", "İstanbul");
        Charity charity2 = new Charity(2,"AFAD", "İstanbul");
        return  List.of(charity1, charity2);
    }

    @GetMapping(value = "/{id}", produces = {"application/json;charset=utf-8"})
    public Charity getCharityById(@PathVariable("id") int charityId){
        Charity charity1 = new Charity(1,"IHH", "İstanbul");
        Charity charity2 = new Charity(2,"AFAD", "İstanbul");
        var charities =  List.of(charity1, charity2);

        Charity result = null;
        for (Charity charity : charities){
            if(charityId == charity.id()){
                result = charity;
            }
        }
        return result;
    }*/

}
