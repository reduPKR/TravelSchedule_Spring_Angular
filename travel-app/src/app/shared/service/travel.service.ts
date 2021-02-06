import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { responsePageable } from '../model/responsePageable.model';

@Injectable({
  providedIn: 'root'
})
export class TravelService {

  apiUrl = "http://localhost:8080/api/travel";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private httpClient: HttpClient) { }

  public getAll(): Observable<responsePageable> {
    return this.httpClient.get<responsePageable>(this.apiUrl);
  }
}
