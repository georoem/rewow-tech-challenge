import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  
  baseUrl = environment.baseUrl;

  constructor(public http:HttpClient) { }

  createAppointment(appointment:any ) {
    return this.http.post(this.baseUrl + '/appointment', appointment);
  }

}
