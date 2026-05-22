import { Component, OnInit } from '@angular/core';

import { VehicleService } from '../vehicle-service';
import { Router } from '@angular/router';
import { Vehicle } from '../vehicle';

@Component({
  selector: 'app-create-vehicle',
  standalone: false,
  templateUrl: './create-vehicle.html',
  styleUrl: './create-vehicle.css',
})
export class CreateVehicle implements OnInit{

  vehicle: Vehicle = new Vehicle();
  constructor(
      private vehicleService: VehicleService,
      private router: Router
  ) {}

  ngOnInit(): void {}

  saveVehicle(){
    this.vehicleService.createVehicle(this.vehicle).subscribe( data => {
      console.log(data);
      this.goToVehicleList();
    },
      error => console.log(error));
  }

  goToVehicleList(){
    this.router.navigate(['parking']);
  }

  onSubmit(){
    console.log(this.vehicle);
    this.saveVehicle();
  }

}
