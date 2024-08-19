export class Routes {
  startPlanet: string;
  endPlanet: string;
  distance: number;
  path: string[];

  constructor(startPlanet: string, endPlanet: string, distance: number, path: string[]) {
    this.startPlanet = startPlanet;
    this.endPlanet = endPlanet;
    this.distance = distance;
    this.path = path;
  }
}

export class AllRoutes {
  routes: Routes[];

  constructor(routes: Routes[]) {
    this.routes = routes;
  }
}

export namespace AlgorithmDefinition {
  export class PathResult {
    distance: number;
    path: string[];

    constructor(distance: number, path: string[]) {
      this.distance = distance;
      this.path = path;
    }
  }
}