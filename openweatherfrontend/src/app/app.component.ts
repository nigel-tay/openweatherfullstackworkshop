import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { OpenweatherService } from './services/openweather.service';
import { Subscription } from 'rxjs';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Weather } from './weather';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(private owService: OpenweatherService, private fb: FormBuilder) {}

  sub$!: Subscription;
  weatherFormGroup!: FormGroup;
  weatherObject: Weather = {description: "", temperature: ""};

  ngOnInit(): void {
    this.weatherFormGroup = this.fb.group({
      city: this.fb.control<string>('', [Validators.required])
    })
  }



  getWeatherByCity() {
    this.sub$ = this.owService.getWeatherByCity(this.weatherFormGroup.value.city)
                              .subscribe({
                                next: (value: any) => {
                                  this.weatherObject.description = value.weather[0].description;
                                  this.weatherObject.temperature = value.main.temp;
                                  console.log(this.weatherObject);
                                },
                                error: (err) => {
                                  console.error(err);
                                },
                                complete: () => {
                                  this.sub$.unsubscribe();
                                }
                              })
  }
}
