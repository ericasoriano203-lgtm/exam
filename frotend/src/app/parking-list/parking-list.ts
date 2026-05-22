import { Component, OnInit } from '@angular/core';
import { Parking} from '../parking'
import { ParkingService } from '../parking-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-parking-list',
  standalone: false,
  templateUrl: './parking-list.html',
  styleUrl: './parking-list.css',
})
export class ParkingList implements OnInit {

  parking!: Parking[];

  constructor(private parkingService: ParkingService,
    private router: Router) {}

  ngOnInit(): void {
    this.getParking();
  }

  private getParking(){
    this.parkingService.getParkingList().subscribe( data => {
      this.parking = data;
    });
  }

  parkingDetails(lot: number){
    this.router.navigate(['parking-details', lot]);
  }

  updateParking(lot: number){
    this.router.navigate(['update-parking', lot]);
  }

  deleteParking(lot: number){
    this.parkingService.deleteParking(lot).subscribe( data => {
      console.log(data);
      this.getParking();
    })
  }
}
