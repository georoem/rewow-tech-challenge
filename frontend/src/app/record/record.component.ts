import { Component, OnInit } from '@angular/core';
import { PetService } from '../pet/pet.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-record',
  templateUrl: './record.component.html',
  styleUrls: ['./record.component.css']
})
export class RecordComponent implements OnInit {

  pet:any;
  appointments:any;
  mode:string;

  constructor(public petService:PetService,
    private route: ActivatedRoute,
    private router: Router) { }

    async ngOnInit(): Promise<any> {
      let idPet = this.route.snapshot.paramMap.get('idPet');
      this.pet = <any>await this.petService.getPetsById(idPet).toPromise();
      this.appointments = <any[]>await this.petService.getApointmentsByPetId(this.pet.id).toPromise();
      this.mode = "RECORD";
    }
}
