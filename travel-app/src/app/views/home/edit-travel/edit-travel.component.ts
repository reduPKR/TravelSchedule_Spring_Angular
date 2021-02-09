import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { mixinInitialized } from '@angular/material/core';
import { MatDialogRef, MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DestinationCity } from 'src/app/shared/model/destination-city.model';
import * as moment from 'moment';
import { TravelService } from 'src/app/shared/service/travel.service';

@Component({
  selector: 'app-edit-travel',
  templateUrl: './edit-travel.component.html',
  styleUrls: ['./edit-travel.component.css']
})
export class EditTravelComponent implements OnInit {
  public travelForm: any;

  constructor(
      public dialogRef: MatDialogRef<EditTravelComponent>,
      public fb: FormBuilder,
      private travelService: TravelService
      @Inject(MAT_DIALOG_DATA) public travel: DestinationCity
    ) { }

  ngOnInit(): void {
    this.initForm();  
  }

  initForm(){
    var aux = this.travel.date.split("T");

    this.travelForm = this.fb.group({
      cidade: [this.travel.cidade, [Validators.required]],
      date: [aux[0], [Validators.required]],
      hora: [aux[1], [Validators.required]]
    });
  }

  editTravel(){
    let travelDate: moment.Moment = moment.utc(this.travelForm.value.date).local();
    this.travelForm.value.date = travelDate.format("YYYY-MM-DD") + 'T' + this.travelForm.value.hora;
    this.travelService.editTravel(this.travelForm.value).subscribe(result => {});
    this.dialogRef.close(true);
    this.travelForm.reset();
    window.location.reload();
  }

  close(){
    this.dialogRef.close(true);
  }
}
