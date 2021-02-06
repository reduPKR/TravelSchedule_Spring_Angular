import { Component, OnInit } from '@angular/core';

export interface Travel {
  id: number;
  destino: string;
  data: string;
}

const list_travel: Travel[] = [
  {id: 1, destino: 'Santos', data: '28/02/2021'},
  {id: 2, destino: 'Curitiba', data: '25/02/2021'},
  
];

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  lista = list_travel;

  constructor() { }

  ngOnInit(): void {
  }

}
