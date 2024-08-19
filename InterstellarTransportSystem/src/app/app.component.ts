import { Component, OnInit } from '@angular/core';
import { AlgorithmDefinition, AllRoutes } from 'src/models/routes.model';
import { Routes } from 'src/models/routes.model';
import { ITSService } from 'src/services/its.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  allRoutes: AllRoutes | null = null;
  shortestRoute: AlgorithmDefinition.PathResult | null = null;

  constructor(private service: ITSService) { }

  findShortestRoute(start: string, end: string): void {
    this.service.getShortestRoute(start, end).subscribe(result => {
      this.shortestRoute = result;
    });
  }
}

