import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DestinationCity } from 'src/app/shared/model/destination-city.model';

@Component({
  selector: 'app-edit-travel',
  templateUrl: './edit-travel.component.html',
  styleUrls: ['./edit-travel.component.css']
})
export class EditTravelComponent implements OnInit {

  constructor(
      public dialogRef: MatDialogRef<EditTravelComponent>,
      @Inject(MAT_DIALOG_DATA) public travel: DestinationCity
    ) { }

  ngOnInit(): void {
  }

}
