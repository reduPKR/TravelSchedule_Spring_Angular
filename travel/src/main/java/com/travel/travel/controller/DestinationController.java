package com.travel.travel.controller;

import com.travel.travel.DTO.DestinationCityDTO;
import com.travel.travel.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/travel")
public class DestinationController {
    @Autowired
    DestinationService service;

    @GetMapping
    public ResponseEntity<List<DestinationCityDTO>> getAll(){
        List<DestinationCityDTO> destinationPage = service.findAll();

        if(destinationPage.isEmpty()) {
            return new ResponseEntity<List<DestinationCityDTO>>(destinationPage, HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<DestinationCityDTO>>(destinationPage, HttpStatus.OK);
        }
    }
}
