package com.TwentySevenFour.back.services.implementation;

import com.TwentySevenFour.back.models.PlanetNames;
import com.TwentySevenFour.back.repository.PlanetNamesRepository;
import com.TwentySevenFour.back.services.PlanetNamesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PlanetNamesImplementation implements PlanetNamesService {
    private final PlanetNamesRepository planetNamesRepository;

    @Override
    public List<PlanetNames> getAllPlanetNames() {
        return planetNamesRepository.findAll();
    }
}
