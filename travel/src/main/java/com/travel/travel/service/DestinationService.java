package com.travel.travel.service;

import com.travel.travel.DTO.DestinationCityDTO;
import com.travel.travel.entity.DestinationCity;
import com.travel.travel.mapper.DestinationMapper;
import com.travel.travel.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class DestinationService {
    @Autowired
    DestinationRepository repository;

    public Page<DestinationCity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<DestinationCity> createTravel(DestinationCityDTO destinationCityDTO) {
        DestinationCity destinationCity = DestinationMapper.INSTANCE.toModel(destinationCityDTO);

        try{
            return trySaveTravel(destinationCity);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    private Page<DestinationCity> trySaveTravel(DestinationCity destinationCity) {
        DestinationCity travel = repository.save(destinationCity);
        return (Page<DestinationCity>) travel;
    }

    public void deleteTravel(long id) {
        repository.deleteById(id);
    }
}
