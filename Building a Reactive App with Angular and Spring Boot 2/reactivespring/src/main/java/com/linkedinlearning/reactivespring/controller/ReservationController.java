package com.linkedinlearning.reactivespring.controller;

import com.linkedinlearning.reactivespring.model.Reservation;
import com.linkedinlearning.reactivespring.service.ReservationService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@RestController
@RequestMapping("${application.path}" + ReservationController.RESOURCE_NAME)
@CrossOrigin
public class ReservationController {
    public static final String RESOURCE_NAME = "reservation";

    private final ReservationService reservationService;

    public ReservationController(final ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("{id}")
    public Mono<Reservation> getReservationById(@PathVariable String id) {
        return reservationService.getReservationById(id);
    }

    @PostMapping
    public Mono<Reservation> createReservation(@RequestBody Mono<Reservation> reservationMono) {
        return reservationMono.flatMap(reservationService::createReservation).onErrorResume(Mono::error);
    }

    @PutMapping("{id}")
    public Mono<Reservation> updateReservation(@PathVariable String id, @RequestBody Mono<Reservation> reservationMono) {
        return reservationMono.flatMap(reservation -> reservationService.updateReservation(id, reservation))
                .switchIfEmpty(Mono.error(new HttpClientErrorException(HttpStatus.BAD_REQUEST)));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteReservation(@PathVariable String id) {
        return reservationService.deleteReservation(id);
    }
}
