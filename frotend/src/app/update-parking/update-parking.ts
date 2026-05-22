import { Component, OnInit } from '@angular/core';
import { ParkingService } from '../parking-service';
import { ActivatedRoute, Router } from '@angular/router';
import { Parking } from '../parking';

@Component({
  selector: 'app-update-parking',
  standalone: false,
  templateUrl: './update-parking.html',
  styleUrl: './update-parking.css',
})
export class UpdateParking implements OnInit {

  lot: number;
  parking: Parking = new Parking();

  constructor(private parkingService: ParkingService,
      private route: ActivatedRoute,
      private router: Router) {}

  ngOnInit(): void {
    this.lot = this.route.snapshot.params['id'];

    this.parkingService.getParkingByLot(this.lot).subscribe(data => {
      this.parking = data;
    }, error => console.log(error));
  }


 onSubmit(){
    this.parkingService.updateParking(this.lot, this.parking).subscribe( data =>{
      this.goToParkingList();
    }
    , error => console.log(error));
 }

 goToParkingList(){
    this.router.navigate(['parking']);
 }

    
}

