import { Component, OnInit } from '@angular/core';
import { MatIconRegistry } from '@angular/material/icon';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { DashboardService } from './dashboard.service';
import { OwnerService } from './owner.service';
import { PetService } from '../pet/pet.service';
import { Pet } from '../model/pet.model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  owner:any;
  pets:any[];
  currentPet:Pet =new Pet();

  constructor(public ownerService:OwnerService,
    public petService:PetService,
    iconRegistry: MatIconRegistry, 
    sanitizer: DomSanitizer, 
    private route: ActivatedRoute,
    private router: Router) {
    iconRegistry.addSvgIcon(
        'calendar',
        sanitizer.bypassSecurityTrustResourceUrl('assets/calendar.svg'));
    iconRegistry.addSvgIcon(
        'pet',
        sanitizer.bypassSecurityTrustResourceUrl('assets/pet.svg'));
    iconRegistry.addSvgIcon(
        'gift',
        sanitizer.bypassSecurityTrustResourceUrl('assets/gift.svg'));
  }

  async ngOnInit(): Promise<any> {
    let idOwner = this.route.snapshot.paramMap.get('idOwner');
    this.owner = await this.ownerService.getOwnerById(idOwner).toPromise();
    this.pets = <any[]>await this.petService.getPetsByIdOwner(this.owner.id).toPromise();
    this.currentPet = this.pets[0];
  }

}
