package com.TwentySevenFour.back.controller;

import com.TwentySevenFour.back.algorithm.AlgorithmDefinition;
import com.TwentySevenFour.back.models.Routes;
import com.TwentySevenFour.back.services.RoutesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class RouteController {

    private final RoutesService routesService;

    @GetMapping("/allRoutes")
    public List<Routes> allRoutes() {
        return routesService.getAllRoutes();
    }

    @RequestMapping(value = "/shortestRoute/{start}/{end}", method = RequestMethod.GET)
    public AlgorithmDefinition.PathResult shortestRoute(@PathVariable String start, @PathVariable String end) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        List<Routes> routes = routesService.getAllRoutes();
        for (Routes route : routes) {
            String startPlanet = route.getPlanet_origin();
            String endPlanet = route.getPlanet_destination();
            double distance = route.getDistance_light_years(); // Ensure double
            AlgorithmDefinition.addEdge(graph, startPlanet, endPlanet, distance);
        }
        AlgorithmDefinition.PathResult result = AlgorithmDefinition.dijkstra(graph, start.toUpperCase(), end.toUpperCase());
        return result;
    }
}