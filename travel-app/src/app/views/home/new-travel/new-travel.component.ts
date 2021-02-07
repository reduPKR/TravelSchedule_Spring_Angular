import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { TravelService } from 'src/app/shared/service/travel.service';

@Component({
  selector: 'app-new-travel',
  templateUrl: './new-travel.component.html',
  styleUrls: ['./new-travel.component.css']
})
export class NewTravelComponent implements OnInit {
  public travelForm: any;

  constructor(
    public dialogRef: MatDialogRef<NewTravelComponent>,
    private fb: FormBuilder,
    private rest: TravelService
  ) { }

  ngOnInit(): void {
    this.initForm();
  }

  initForm(){
    this.travelForm = this.fb.group({
      nome: ['', [Validators.required]],
      date: ['', [Validators.required]],
      hora: ['', [Validators.required]]
    });
  }

  close(){
    this.dialogRef.close(true);
    this.travelForm.reset();
  }
}
