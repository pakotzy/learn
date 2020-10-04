package com.linkedinlearning.reactivespring.service;

import com.linkedinlearning.reactivespring.model.Reservation;
import com.linkedinlearning.reactivespring.repo.ReservationRepository;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(final ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Mono<Reservation> getReservationById(String id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Mono<Reservation> createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Mono<Reservation> updateReservation(String id, Reservation reservation) {
        return getReservationById(id).flatMap(dbReservation -> {
            reservation.setId(id);
            return reservationRepository.save(reservation);
        });
    }

    @Override
    public Mono<Void> deleteReservation(String id) {
        return reservationRepository.deleteById(id);
    }
}
