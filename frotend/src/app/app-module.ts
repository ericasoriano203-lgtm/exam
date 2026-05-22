import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { ParkingList } from './parking-list/parking-list';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { CreateParking } from './create-parking/create-parking';
import { FormsModule } from '@angular/forms';
import { UpdateParking } from './update-parking/update-parking';
import { CreateVehicle } from './create-vehicle/create-vehicle';



@NgModule({
  declarations: [App, ParkingList, CreateParking, UpdateParking, CreateVehicle],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideClientHydration(withEventReplay()),
    provideHttpClient(withFetch()),
  ],
  bootstrap: [App],
})
export class AppModule {}
