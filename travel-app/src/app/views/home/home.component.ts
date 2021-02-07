import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { NewTravelComponent } from './new-travel/new-travel.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  new_travel(): void{
    const dialogRef = this.dialog.open(NewTravelComponent, {
      minWidth: '500px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('Bye');
    });
  }
}
