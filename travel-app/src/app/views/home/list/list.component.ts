import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { DestinationCity } from 'src/app/shared/model/destination-city.model';
import { TravelService } from 'src/app/shared/service/travel.service';
import { EditTravelComponent } from '../edit-travel/edit-travel.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  lista: DestinationCity[] = [];

  constructor(
    public travelService: TravelService,
    public sanitizer: DomSanitizer,
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll(){
    this.travelService.getAll().subscribe(
      data=>{
        this.lista = data.content;
      }
    );
    console.log(this.lista)
  }

  delete(id: any){
    this.travelService.deleteTravel(id).subscribe(result => {});
    window.location.reload();
  }

  editTravel(item: any){
    const dialogRef = this.dialog.open(EditTravelComponent, {
      minWidth: '500px',
      data: item
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('Bye');
    });
  }
}
