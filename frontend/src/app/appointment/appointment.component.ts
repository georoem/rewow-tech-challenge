import { Component, OnInit, Inject, Input, ViewEncapsulation } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { PetService } from '../pet/pet.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AppointmentService } from './appointment.service';
import { Pet } from '../model/pet.model';
import { Appointment } from '../model/appointment.model';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {

  @Input()
  mode: string;
  pet:Pet;
  appointments:any[];

  constructor(public dialog: MatDialog,
    public appointmentService:AppointmentService,
    public petService:PetService,
    private route: ActivatedRoute,
    private router: Router) { }

  async ngOnInit(): Promise<any> {
    let idPet = this.route.snapshot.paramMap.get('idPet');
    this.pet = <Pet>await this.petService.getPetsById(idPet).toPromise();
    this.appointments = <any[]>await this.petService.getApointmentsByPetId(this.pet.id).toPromise();
  }

  openDialog() {
    const dialogRef = this.dialog.open(AppointmentDialog, {
      width: '250px'
    });


    dialogRef.afterClosed().subscribe(result => {
      this.createAppointment(result.data);
    });
  }

  async createAppointment(data) {
    let appointment:Appointment = {
      pet: this.pet,
      services: data.services,
      date:data.date
    }

    let response = await this.appointmentService.createAppointment(appointment).toPromise();
    this.updateAppointments();
  }

  async updateAppointments() {
    this.appointments = <Appointment[]>await this.petService.getApointmentsByPetId(this.pet.id).toPromise();
  }

}

@Component({
  selector: 'appointment-dialog',
  templateUrl: './appointment.dialog.html',
})
export class AppointmentDialog {

  services:any[] = [
    {
      id:5,
      name: "Corte de pelo",
      checked: false
    }, {
      id:2,
      name: "Vacunación",
      checked: false
    }, {
      id:4,
      name: "Baño",
      checked: false
    }, {
      id:3,
      name: "Desparasitación",
      checked: false
    }, {
      id:5,
      name: "Cita Médica",
      checked: false
    }
  ];

  minDate: Date;
  date: Date;

  constructor(
    public dialogRef: MatDialogRef<AppointmentDialog>,
    @Inject(MAT_DIALOG_DATA) public data) {
      const current = new Date();
      this.minDate = new Date(current.getFullYear(), current.getMonth(), current.getDay()+1);
    }

  onNoClick(): void {
    this.dialogRef.close();
  }

  createAppointment(){
    let data = {
      services: this.services.filter(service => service.checked),
      date: this.date
    }
    this.dialogRef.close({ data: data });
  }
}
