import { Pet } from './pet.model';

export class Appointment {
    id?:number;
    pet: Pet;
    services: any[];
    date:Date;

    constructor() {
    }
  }