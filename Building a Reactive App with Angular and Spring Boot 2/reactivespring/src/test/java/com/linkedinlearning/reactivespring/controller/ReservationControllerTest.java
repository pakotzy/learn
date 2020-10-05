package com.linkedinlearning.reactivespring.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.linkedinlearning.reactivespring.model.Reservation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Mono;

@DisplayName("The ReservationController")
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class ReservationControllerTest {
    @Value("${application.path}" + ReservationController.RESOURCE_NAME)
    public String resourcePath;

    @Autowired
    private WebTestClient webTestClient;
    private Reservation reservation;

    @BeforeAll
    void setUp() {
        reservation = new Reservation(123l, LocalDate.now(), 
                LocalDate.now().plusDays(10), new BigDecimal(12.3));
    }

    @Nested
    @DisplayName("GetAll")
    class GetAll {
        @Test
        @DisplayName("return ok status and reservation list")
        void Get_All_Reservations() {
            webTestClient.get().uri(resourcePath).exchange()
                    .expectStatus().isOk().expectBodyList(Reservation.class);
        }
    }

    @Nested
    @DisplayName("Create")
    class Create {
        @Test
        @DisplayName("return ok status and new reservation body")
        void Create_Reservation() {
            webTestClient.post().uri(resourcePath)
                    .body(Mono.just(reservation), Reservation.class).exchange()
                    .expectStatus().isOk()
                    .expectBody(Reservation.class);
        }
    }
}
