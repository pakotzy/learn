import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'reservation-app';

  constructor(private http: HttpClient) { }

  private baseUrl: string = 'http://localhost:8080';
  private apiPath: string = '/v1/api';
  private reservationUrl: string = this.baseUrl + this.apiPath + '/reservation';

  rooms: Room[];

  ngOnInit() {
    this.rooms = [new Room("1", "1", "199"), new Room("2", "2", "199"), new Room("3", "3", "299"),
    new Room("4", "4", "399"), new Room("5", "5", "499"), new Room("6", "6", "599")];
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