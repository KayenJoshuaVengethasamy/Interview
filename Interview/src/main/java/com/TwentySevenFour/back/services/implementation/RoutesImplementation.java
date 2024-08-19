package com.TwentySevenFour.back.services.implementation;

import com.TwentySevenFour.back.models.PlanetNames;
import com.TwentySevenFour.back.models.Routes;
import com.TwentySevenFour.back.repository.PlanetNamesRepository;
import com.TwentySevenFour.back.repository.RoutesRepository;
import com.TwentySevenFour.back.services.PlanetNamesService;
import com.TwentySevenFour.back.services.RoutesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class RoutesImplementation implements RoutesService {
    @Autowired
    private final RoutesRepository routesRepository;

    @Override
    public List<Routes> getAllRoutes() {
        return routesRepository.findAll();
    }

    @Override
    public Routes getRoutesByID(Long ID) {
        Optional<Routes> routes =routesRepository.findById(ID);
        if(routes.isPresent()){
            return routes.get();
        }
        return null;
    }

    @Override
    public Routes getRouteByNodes(String origin, String destination){
      return null;
    }


}
