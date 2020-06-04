import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PetComponent } from './pet/pet.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { RecordComponent } from './record/record.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { AppComponent } from './app.component';
import { StoreComponent } from './store/store.component';


const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'pet/:idOwner', component: PetComponent, pathMatch: 'full' },
  {
      path: 'dashboard/:idOwner', component: DashboardComponent, children: [
         { path: '', redirectTo: 'record', pathMatch: 'full' },
          { path: 'record/:idPet', component: RecordComponent },
          { path: 'appointment/:idPet', component: AppointmentComponent },
          { path: 'store', component: StoreComponent }
      ]
  },
  { path: '**',  redirectTo: '/login', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
