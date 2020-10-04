package com.linkedinlearning.reactivespring.service;

import com.linkedinlearning.reactivespring.model.Reservation;

import reactor.core.publisher.Mono;

public interface ReservationService {
    Mono<Reservation> getReservationById(String id);

    Mono<Reservation> createReservation(Reservation reservation);

    Mono<Reservation> updateReservation(String id, Reservation reservation);

    Mono<Void> deleteReservation(String id);
}
