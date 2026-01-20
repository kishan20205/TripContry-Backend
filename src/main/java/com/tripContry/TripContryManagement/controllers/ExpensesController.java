package com.tripContry.TripContryManagement.controllers;

import com.tripContry.TripContryManagement.entities.Expense;
import com.tripContry.TripContryManagement.entities.Trip;
import com.tripContry.TripContryManagement.repositories.ExpensesRepository;
import com.tripContry.TripContryManagement.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/expenses")
public class ExpensesController {

    private final ExpensesRepository expensesRepository;
    private final TripRepository tripRepository;

    public ExpensesController(ExpensesRepository expensesRepository, TripRepository tripRepository) {
        this.expensesRepository = expensesRepository;
        this.tripRepository = tripRepository;
    }

    @GetMapping("/{trip_id}")
    public List<Expense> findAllByTripId(@PathVariable long trip_id) {
        return expensesRepository.findAllByTripId(trip_id);
    }

    @PostMapping("/{trip_id}")
    public Expense createExpenses(@PathVariable long trip_id, @RequestBody Expense expense) {
        Trip trip = tripRepository.findById(trip_id).orElseThrow(()-> new RuntimeException("Trip not found !!"));

        expense.setTrip(trip);
        return expensesRepository.save(expense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpenses(@PathVariable String id) {
         expensesRepository.deleteById(id);

         return ResponseEntity.ok("Deleted expense with id " + id);
    }
}
