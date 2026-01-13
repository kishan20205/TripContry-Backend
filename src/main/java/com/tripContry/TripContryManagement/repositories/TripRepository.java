package com.tripContry.TripContryManagement.repositories;

import com.tripContry.TripContryManagement.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

}
