package com.travel.travel.service;

import com.travel.travel.mapper.DestinationMapper;
import com.travel.travel.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinationService {
    @Autowired
    DestinationRepository repository;
    private final DestinationMapper destinationMapper = DestinationMapper.INSTANCE;


}
