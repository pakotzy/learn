package com.linkedinlearning.reactivespring.repo;

import com.linkedinlearning.reactivespring.model.Reservation;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReservationRepository extends ReactiveCrudRepository<Reservation, String> {

}
