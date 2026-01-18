package com.tripContry.TripContryManagement.controllers;

import com.tripContry.TripContryManagement.entities.Trip;
import com.tripContry.TripContryManagement.repositories.TripRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/trips")
public class TripController {

    private final int PAGE_SIZE = 2;

    private final TripRepository tripRepository;

    public TripController(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @GetMapping
    public Page<Trip> getAllTrips(@RequestParam(defaultValue = "id") String sortBy,
                                  @RequestParam(defaultValue = "0") Integer pageNumber) {
//        return tripRepository.findAll(Sort.by(Sort.Direction.DESC, sortBy, "name"));
//        return tripRepository.findAll(Sorrt.by(Sort.Order.desc(sortBy)));

        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);

        return tripRepository.findAll(pageable);
    }

    @GetMapping("/{trip_id}")
    public Trip getTripById(@PathVariable("trip_id") Long trip_id) {
        return tripRepository.findById(trip_id).orElse(null);
    }

    @PostMapping("/create-trip")
    public Trip createTrip(@RequestBody Trip trip) {
        return tripRepository.save(trip);
    }

    @DeleteMapping("/{trip_id}")
    public ResponseEntity<String> deleteById(@PathVariable("trip_id") Long trip_id) {
        tripRepository.deleteById(trip_id);

        return ResponseEntity.ok("Deleted trip with id " + trip_id);
    }

}
