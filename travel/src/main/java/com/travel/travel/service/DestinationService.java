package com.travel.travel.service;

import com.travel.travel.DTO.DestinationCityDTO;
import com.travel.travel.entity.DestinationCity;
import com.travel.travel.mapper.DestinationMapper;
import com.travel.travel.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class DestinationService {
    @Autowired
    DestinationRepository repository;

    public List<DestinationCityDTO> findAll() {
        List<DestinationCity> list = repository.findAll();
        return list.stream().map(DestinationMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }
}
