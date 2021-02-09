package com.travel.travel.controller;

import com.travel.travel.DTO.DestinationCityDTO;
import com.travel.travel.entity.DestinationCity;
import com.travel.travel.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/travel")
public class DestinationController {
    @Autowired
    DestinationService service;

    @GetMapping
    public ResponseEntity<Page<DestinationCity>> getAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        Page<DestinationCity> destinationPage = service.findAll(pageable);

        if(destinationPage.isEmpty()) {
            return new ResponseEntity<Page<DestinationCity>>(destinationPage, HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Page<DestinationCity>>(destinationPage, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Page<DestinationCity>> createTravel(@RequestBody @Valid DestinationCityDTO destinationCityDTO){
        Page<DestinationCity> destinationCity = service.createTravel(destinationCityDTO);
        return new ResponseEntity<Page<DestinationCity>>(destinationCity, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Page<DestinationCity>> deleteTravel(@PathVariable("id") long id){
        service.deleteTravel(id);
        return new ResponseEntity<Page<DestinationCity>>((Page<DestinationCity>) null, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Page<DestinationCity>> putTravel(@RequestBody @Valid DestinationCityDTO destinationCityDTO){
        Page<DestinationCity> destinationCity = service.createTravel(destinationCityDTO);
        return new ResponseEntity<Page<DestinationCity>>(destinationCity, HttpStatus.CREATED);
    }
}
