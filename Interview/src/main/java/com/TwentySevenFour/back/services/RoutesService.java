package com.TwentySevenFour.back.services;

import com.TwentySevenFour.back.models.PlanetNames;
import com.TwentySevenFour.back.models.Routes;

import java.util.List;

public interface RoutesService {
    List<Routes> getAllRoutes();

    Routes getRoutesByID(Long ID);
    Routes getRouteByNodes(String origin, String destination);
}
