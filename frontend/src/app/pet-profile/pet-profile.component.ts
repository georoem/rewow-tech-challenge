import { Component, OnInit, Input } from '@angular/core';
import { MatIconRegistry } from '@angular/material/icon';
import { DomSanitizer } from '@angular/platform-browser';
import { Pet } from '../model/pet.model';
import { ActivatedRoute, Router } from '@angular/router';
import { PetService } from '../pet/pet.service';

@Component({
  selector: 'app-pet-profile',
  templateUrl: './pet-profile.component.html',
  styleUrls: ['./pet-profile.component.css']
})
export class PetProfileComponent implements OnInit {

  pet:Pet =new Pet();

  constructor(iconRegistry: MatIconRegistry,
    sanitizer: DomSanitizer,
    public petService: PetService,
    private route: ActivatedRoute,
    private router: Router) {
    iconRegistry.addSvgIcon(
      'photography',
      sanitizer.bypassSecurityTrustResourceUrl('assets/photography.svg'));
  }

  async ngOnInit(): Promise<any> {
    let idPet = this.route.snapshot.paramMap.get('idPet');
    this.pet = <Pet>await this.petService.getPetsById(idPet).toPromise();
  }

}
