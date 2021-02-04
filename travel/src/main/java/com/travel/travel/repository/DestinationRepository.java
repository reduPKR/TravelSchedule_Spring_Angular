package com.travel.travel.repository;

import com.travel.travel.entity.DestinationCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<DestinationCity,Long> {
}
