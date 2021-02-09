import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { responsePageable } from '../model/responsePageable.model';
import { DestinationCity } from '../model/destination-city.model';

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

  public postTravel(travel: any): Observable<DestinationCity> {
    return this.httpClient.post<any>(this.apiUrl, travel, this.httpOptions);
  }

  public deleteTravel(id: any) {
    return this.httpClient.delete<any>(this.apiUrl+"/"+id);
  }

  public editTravel(travel: any): Observable<DestinationCity> {
    return this.httpClient.put<any>(this.apiUrl, travel, this.httpOptions);
  }
}
