import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vehicle } from './vehicle';



@Injectable({
  providedIn: 'root',
})
export class VehicleService {
  private baseURL = "http://localhost:8080/smartpark/vehicle"

  constructor(private httpClient: HttpClient) {}

  getVehicleList(): Observable<Vehicle[]>{
    return this.httpClient.get<Vehicle[]>(`${this.baseURL}`);     
  }

  createVehicle(vehicle: Vehicle): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, vehicle);
  }

  getVehicleByLot(lot: number): Observable<Vehicle>{
     return this.httpClient.get<Vehicle>(`${this.baseURL}/${lot}`);
  }

   updateVehicle(lot: number, vehicle: Vehicle): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${lot}`, vehicle);
  }

  deleteVehicle(lot: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${lot}`);
  }

}

