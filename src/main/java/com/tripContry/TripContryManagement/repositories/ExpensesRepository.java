package com.tripContry.TripContryManagement.repositories;

import com.tripContry.TripContryManagement.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpensesRepository extends JpaRepository<Expense, String> {
    List<Expense> findAllByTripId(long tripId);
}
