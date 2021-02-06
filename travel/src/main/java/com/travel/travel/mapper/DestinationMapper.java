package com.travel.travel.mapper;

import com.travel.travel.DTO.DestinationCityDTO;
import com.travel.travel.entity.DestinationCity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface DestinationMapper {
    DestinationMapper INSTANCE = Mappers.getMapper(DestinationMapper.class);

    DestinationCity toModel(DestinationCityDTO destinationCityDTO);
    DestinationCityDTO toDTO(DestinationCity destinationCity);
}
