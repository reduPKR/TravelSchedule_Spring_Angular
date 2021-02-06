package com.travel.travel.service;

import com.travel.travel.DTO.DestinationCityDTO;
import com.travel.travel.entity.DestinationCity;
import com.travel.travel.mapper.DestinationMapper;
import com.travel.travel.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class DestinationService {
    @Autowired
    DestinationRepository repository;

    public Page<DestinationCity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
