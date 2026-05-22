import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Parking } from './parking';



@Injectable({
  providedIn: 'root',
})
export class ParkingService {
  private baseURL = "http://localhost:8080/smartpark/parking"

  constructor(private httpClient: HttpClient) {}

  getParkingList(): Observable<Parking[]>{
    return this.httpClient.get<Parking[]>(`${this.baseURL}`);     
  }

  createParking(parking: Parking): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, parking);
  }

  getParkingByLot(lot: number): Observable<Parking>{
     return this.httpClient.get<Parking>(`${this.baseURL}/${lot}`);
  }

   updateParking(lot: number, parking: Parking): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${lot}`, parking);
  }

  deleteParking(lot: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${lot}`);
  }

}

