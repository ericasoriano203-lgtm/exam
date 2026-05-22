import { Component, OnInit } from '@angular/core';

import { ParkingService } from '../parking-service';
import { Router } from '@angular/router';
import { Parking } from '../parking';

@Component({
  selector: 'app-create-parking',
  standalone: false,
  templateUrl: './create-parking.html',
  styleUrl: './create-parking.css',
})
export class CreateParking implements OnInit{

  parking: Parking = new Parking();
  constructor(
      private parkingService: ParkingService,
      private router: Router
  ) {}

  ngOnInit(): void {}

  saveParking(){
    this.parkingService.createParking(this.parking).subscribe( data => {
      console.log(data);
      this.goToParkingList();
    },
      error => console.log(error));
  }

  goToParkingList(){
    this.router.navigate(['parking']);
  }

  onSubmit(){
    console.log(this.parking);
    this.saveParking();
  }

}
