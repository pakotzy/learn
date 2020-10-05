import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  constructor(private http: HttpClient) { }

  private baseUrl: string = 'http://localhost:8080';
  private apiPath: string = '/api/v1';
  private reservationUrl: string = this.baseUrl + this.apiPath + '/reservation';

  getReservations(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(this.reservationUrl);
  }

  createReservation(body: ReservationRequest): Observable<Reservation> {
    let httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    }

    return this.http.post<Reservation>(this.reservationUrl, body, httpOptions);
  }
}

export class ReservationRequest {
  roomNumber: number;
  checkIn: Date;
  checkOut: Date;
  price: number;

  constructor(reservation: Reservation) {
    this.roomNumber = reservation.roomNumber;
    this.checkIn = reservation.checkIn;
    this.checkOut = reservation.checkOut;
    this.price = reservation.price;
  }
}

export interface Reservation {
  id?: string;
  roomNumber: number;
  checkIn: Date;
  checkOut: Date;
  price: number;
}