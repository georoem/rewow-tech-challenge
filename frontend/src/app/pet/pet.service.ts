import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Pet } from '../model/pet.model';

@Injectable({
  providedIn: 'root'
})
export class PetService {
  
  baseUrl = environment.baseUrl;

  constructor(public http:HttpClient) { }

  createPet(pet: Pet) {
    return this.http.post(this.baseUrl+"/pet", pet);
  }

  getPetsByIdOwner(idOwner:string) {
    return this.http.get(this.baseUrl+"/owner/"+idOwner+"/pet");
  }

  getPetsById(idPet: any) {
    return this.http.get(this.baseUrl+"/pet/"+idPet);
  }

  getApointmentsByPetId(idPet: number) {
    return this.http.get(this.baseUrl+"/pet/"+ idPet + "/appointment");
  }

}
