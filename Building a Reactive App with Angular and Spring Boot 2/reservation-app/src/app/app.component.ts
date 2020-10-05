import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ReservationRequest, ReservationService, Reservation } from './reservation.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'reservation-app';

  constructor(private reservationService: ReservationService) {}

  rooms: Room[];
  roomSearchForm: FormGroup;

  checkIn: Date;
  checkOut: Date;
  roomNumber: number;
  price: number;

  reservations: Reservation[];

  ngOnInit() {
    this.roomSearchForm = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl(''),
      roomNumber: new FormControl('')
    });

    this.roomSearchForm.valueChanges.subscribe(form => {
      this.checkIn = form.checkin;
      this.checkOut = form.checkout;

      if (form.roomNumber) {
        let roomValues: string[] = form.roomNumber.split('|');
        this.roomNumber = Number(roomValues[0]);
        this.price = Number(roomValues[1]);
      }
    });

    this.rooms = [new Room("1", "1", "199"), new Room("2", "2", "199"), new Room("3", "3", "299"),
        new Room("4", "4", "399"), new Room("5", "5", "499"), new Room("6", "6", "599")];

    this.getReservations();
  }

  getReservations() {
    this.reservationService.getReservations()
      .subscribe(result => {
        console.log(result);
        this.reservations = result;
      })
  }

  createReservation() {
    this.reservationService.createReservation(new ReservationRequest({
      checkIn: this.checkIn, checkOut: this.checkOut, roomNumber: this.roomNumber, price: this.price
    }))
      .subscribe(result => this.reservations.push(result));
  }
}

export class Room {
  id: string;
  roomNumber: string;
  price: string;

  constructor(id: string, roomNumber: string, price: string) {
    this.id = id;
    this.roomNumber = roomNumber;
    this.price = price;
  }
}