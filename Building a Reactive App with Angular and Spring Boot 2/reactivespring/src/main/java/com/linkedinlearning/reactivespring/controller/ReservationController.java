package com.linkedinlearning.reactivespring.controller;

import com.linkedinlearning.reactivespring.model.Reservation;

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

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("${application.path}" + ReservationController.RESOURCE_NAME)
@CrossOrigin
public class ReservationController {
    public static final String RESOURCE_NAME = "reservation";

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> getReservationById(@PathVariable String id) {
        return Mono.just(new Reservation());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> createReservation(@RequestBody Mono<Reservation> reservationMono) {
        return reservationMono.onErrorResume(error -> {
            error.printStackTrace();
            return Mono.error(error);
        });
    }

    @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> replaceReservation(@PathVariable String id, @RequestBody Mono<Reservation> reservationMono) {
        return reservationMono;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Object> deleteReservation(@PathVariable String id) {
        return Mono.empty();
    }
}
