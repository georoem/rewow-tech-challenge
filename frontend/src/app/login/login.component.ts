import { Component, OnInit, ViewEncapsulation, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialog } from '@angular/material/dialog';
import { OwnerService } from '../dashboard/owner.service';
import { Owner } from '../model/owner.model';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class LoginComponent implements OnInit {

  owner:Owner;

  constructor(public dialog: MatDialog,
    public ownerService: OwnerService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
  }

  openDialog() {
    const dialogRef = this.dialog.open(SocialMediaDialog, {
      width: '250px'
    });


    dialogRef.afterClosed().subscribe(result => {
      this.createOwner(result.data);
    });
  }

  async createOwner(owner:Owner) {
    this.owner = await <any>this.ownerService.createOwner(owner).toPromise();
    this.router.navigate(['/pet', this.owner.id]);
  }

}

@Component({
  selector: 'social-media-dialog',
  templateUrl: './social-media.dialog.html',
})
export class SocialMediaDialog {

  owner:Owner;
  constructor(
    public dialogRef: MatDialogRef<SocialMediaDialog>,
    @Inject(MAT_DIALOG_DATA) public data) {
      this.owner = new Owner();
    }

  onNoClick(): void {
    this.dialogRef.close();
  }

  createOwner(){
    this.dialogRef.close({ data: this.owner });
  }
}
