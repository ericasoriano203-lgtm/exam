import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ParkingList } from './parking-list/parking-list';
import { CreateParking } from './create-parking/create-parking';
import { UpdateParking } from './update-parking/update-parking';
import { CreateVehicle} from './create-vehicle/create-vehicle';

const routes: Routes = [
  {path: 'parking', component: ParkingList},
  {path: 'create-parking', component: CreateParking},
  {path: '', redirectTo: 'parking', pathMatch: 'full'},
  {path: 'update-parking/:id', component: UpdateParking},
  {path: 'create-vehicle', component: CreateVehicle},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
