import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { DestinationCity } from 'src/app/shared/model/destination-city.model';
import { TravelService } from 'src/app/shared/service/travel.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  lista: DestinationCity[] = [];

  constructor(
    public travelService: TravelService,
    public sanitizer: DomSanitizer
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
  }
}
