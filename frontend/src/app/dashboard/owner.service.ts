import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Owner } from '../model/owner.model';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  baseUrl = environment.baseUrl;

  constructor(public http:HttpClient) { }

  getOwnerById(idOwner: any) {
    return this.http.get(this.baseUrl+"/owner/"+idOwner);
  }

  createOwner(owner: Owner) {
    return this.http.post(this.baseUrl+"/owner", owner);
  }
}
