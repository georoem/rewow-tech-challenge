import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import { HttpClientModule } from '@angular/common/http';
import {MatDialogModule} from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule, MatRippleModule} from '@angular/material/core';
import {MatExpansionModule} from '@angular/material/expansion';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent, SocialMediaDialog } from './login/login.component';
import { PetComponent } from './pet/pet.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AppointmentComponent, AppointmentDialog } from './appointment/appointment.component';
import { PetProfileComponent } from './pet-profile/pet-profile.component';
import { RecordComponent } from './record/record.component';
import { StoreComponent } from './store/store.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PetComponent,
    DashboardComponent,
    AppointmentComponent,
    AppointmentDialog,
    SocialMediaDialog,
    PetProfileComponent,
    RecordComponent,
    StoreComponent
  ],
  imports: [
    MatDialogModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatSelectModule,
    MatButtonModule,
    MatCardModule,
    MatSidenavModule,
    MatListModule,
    HttpClientModule,
    FormsModule,
    MatSlideToggleModule,
    MatGridListModule,
    MatCheckboxModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatRippleModule,
    MatExpansionModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
