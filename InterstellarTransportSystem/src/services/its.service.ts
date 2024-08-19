import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Routes } from '@angular/router';
import { AlgorithmDefinition, AllRoutes } from 'src/models/routes.model';


@Injectable({
  providedIn: 'root'
})
export class ITSService {
  private baseURL = 'http://localhost:8080'; 

  constructor(private http: HttpClient) { }

  getShortestRoute(startPlanet: string, endPlanet: string): Observable<AlgorithmDefinition.PathResult> {
    return this.http.get<AlgorithmDefinition.PathResult>(`${this.baseURL}/shortestRoute/${startPlanet}/${endPlanet}`);
  }

  getAllRoutes(): Observable<AllRoutes> {
    return this.http.get<AllRoutes>(`${this.baseURL}/allRoutes`);
  }
}