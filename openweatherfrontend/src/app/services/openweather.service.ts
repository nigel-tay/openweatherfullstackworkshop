import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OpenweatherService {

  constructor(private httpClient: HttpClient) { }

  getWeatherByCity(city: string): Observable<string> {
    let queryParams = new HttpParams()
                          .set("city", city);
    return this.httpClient.get<string>('http://localhost:8080/api/getweather', {params: queryParams})
  }
}
