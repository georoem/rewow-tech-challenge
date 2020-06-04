export class Pet {
    id:number;
    name:string;
    type:string;
    age:number;
    breed:string;
    owner:{
      id:number;
    };
  
    constructor(ownerId?: number) {
      this.owner = {id:ownerId};
    }
  }