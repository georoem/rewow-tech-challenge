import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { PetService } from './pet.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Pet } from '../model/pet.model';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {

  pet:Pet;
  idOwner;

  types:any[] = ["GATO", "PERRO", "PEZ", "OTRO"];

  constructor(public petService:PetService, private route: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit(): void {
    this.idOwner = this.route.snapshot.paramMap.get('idOwner');
    this.pet = new Pet(this.idOwner);
  }

  createPet() {
    this.petService.createPet(this.pet).subscribe(response => {
      this.router.navigate(['/dashboard', this.idOwner ]);
    })
  }

}