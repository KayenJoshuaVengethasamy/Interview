package com.TwentySevenFour.back.controller;

import com.TwentySevenFour.back.models.PlanetNames;
import com.TwentySevenFour.back.services.PlanetNamesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class PlanetNamesController {
        private final PlanetNamesService planetNamesService;

        @GetMapping("/allPlanets")
        public List<PlanetNames> allPlanets() {
            return planetNamesService.getAllPlanetNames();
        }
    }
